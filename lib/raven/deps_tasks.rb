#!/usr/bin/env ruby

#  Copyright 2006 Matthieu Riou
#
#  Licensed under the Apache License, Version 2.0 (the "License");
#  you may not use this file except in compliance with the License.
#  You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
#  Unless required by applicable law or agreed to in writing, software
#  distributed under the License is distributed on an "AS IS" BASIS,
#  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#  See the License for the specific language governing permissions and
#  limitations under the License.

require 'rubygems'
require 'rake'
require 'set'
require 'fileutils'

module Raven

  class GemNotFoundException < RuntimeError; end
  class AmbiguousGemException < RuntimeError; end
  
  # Task used to declare a set of dependencies your project relies
  # upon. As many dependency tasks as necessary can be declared
  # (each grouping as many dependency as you like). For each declared
  # dependency, a Gem is searched in your local repository and then if
  # it can't be found, in the specified remote repositories (by setting
  # <em>sources</em>). Gems are searched by name ENDING with the name
  # you provided.
  # 
  # As an example, specifying 'wsdl4j' will correctly find the Gem
  # named wsdl4j-wsdl4j but specifying 'axis2' WILL NOT give you all
  # axis2 Gems. Actually only one Gem can be selected by each of the
  # specified Gem, otherwise you'll see an error asking you to be more
  # specific.
  # 
  # Once the correct Gem has been found, if it's not local it will be
  # automatically be downloaded and installed.
  # 
  # If no version is provided, and the Gem isn't present locally, the 
  # latest version will be fetched. If a local version can be found 
  # locally, this version will be used without any download.
  # 
  # Example of dependency specification:
  # 
  # dependency 'deps' do |t| 
  #   t.deps << [{'commons-logging' => '1.1'}, 'commons-pool']
  #   t.deps << ['commons-lang', 'wsdl4j', 'log4j']
  # end
  # 
  # See also Raven::MavenLocalRepoImport and Raven::GemRepoBuilder to 
  # learn more about how to build a Gem repository to get started.
  # 
  # Alternatively dependencies can be directly declared manually on 
  # jar files in your file system. This allows you to manage your 
  # dependencies yourself without using Gem or any other repository.
  # 
  # dependency 'deps' do |t|
  #   t.libs = Dir.glob('lib/**/*.jar')
  # end
  class DependencyTask < Rake::Task
    attr_reader :gem_deps
  
    # Check dependencies and installs them sometimes.
    def execute
      super
      ambiguous, notfound = [], []
      # Installing missing Gems (if there are)
      if @deps
        @gem_deps = @deps.flatten.collect do |dep|
          # Wrapping in an array, we might not have an array with version
          # as dependency.
          deparr = dep.respond_to?(:to_a) ? dep.to_a.flatten : [dep]
          begin
            Raven::GemInstaller.install_or_not(*deparr)
          rescue GemNotFoundException => gnfe
            notfound << gnfe.message
          rescue AmbiguousGemException => age
            ambiguous << age
          end
        end
        unless notfound.empty? && ambiguous.empty?
          raise(RuntimeError, notfound.join($/) + $/ + ambiguous.join($/))
        end
      end
      # Getting dependencies from eventual prerequisites
      Raven.prereq_filter(prerequisites, :gem_deps) do |dep_task|
        @gem_deps += dep_task.gem_deps if dep_task.gem_deps
      end
    end
    
    def deps
      @deps ||= []
    end
    
    def libs 
      @libs ||= [] 
    end
    def libs=(l)
      @libs = l
    end
  end
    
  # Calls Gem installer to install a Gem (very predictible behaviour).
  # Well, but if the Gem is already there, it won't be installed. This 
  # guy's a smart one.
  module GemInstaller
  
    # Possibly installs a Gem... or not. If it's already present installation
    # will just be skipped. The path to the gem root is always returned though.
    # The provided gem name is first looked up with a query in the repositories
    # to support partial names (i.e only artifactId).
    def self.install_or_not(gemname, version='*')
      # TODO Add support for regular expressions for gem name, allows multiple 
      # selected gems
      hems = resolve(gemname, version)
      gem_spec = hems[0]
      # TODO Handle Gem dependencies
      unless hems[1]
        installer = Gem::RemoteInstaller.new
        params = [gem_spec.name, gem_spec.version.to_s, false]
        params << RAVEN_HOME if defined?(GEMS_IN_HOME)
        gem_spec = installer.install(*params)[0]
      end
      gem_spec.full_gem_path
    end
    
    # Resolves a Gem partial name (like only the artifactId) to a full name 
    # and eventually checks its versions. Returns an array with the found Gem
    # in the first position and a boolean indicating whether the array has
    # been found locally or not in second position.
    def self.resolve(gemname, version)
      # Search local occurences first, it's faster. Moreover we'll only
      # return local versions, avoiding a constant download of latest versions
      # when nothing specific is provided.
      gems = Gem::cache.search(/.*#{gemname}$/)
      local = select_gem(gemname, version, gems, true)
      puts "Using local gem #{local[0].name} (#{local[0].version}) to satisfy dependency #{gemname}" if RakeFileUtils.verbose_flag && local
      return local if local
      begin
        if (Gem::RubyGemsPackageVersion != "0.9.0")
          gems = Gem::SourceInfoCache.search(/.*#{gemname}$/)
        else
          gems = Gem::RemoteInstaller.new().search(/.*#{gemname}$/)
        end
      rescue Exception => rt
        puts rt.to_s
        puts rt.backtrace.join("\n")
        puts "The gem #{gemname} from your dependencies couldn't be found locally"
        puts "and the connection to a Gem repository failed."
        exit
      end 
      remote = select_gem(gemname, version, gems.flatten, false)
      puts "Downloading remote gem #{remote[0].name} (#{remote[0].version}) to satisfy dependency #{gemname}" if RakeFileUtils.verbose_flag && remote
      return remote if remote
      
      # Nothing found: Houston, we have a problem
      raise(GemNotFoundException, "Couldn't find any Gem from name #{gemname} and version #{version}") unless remote
    end
    
    private
    
    def self.select_gem(gemname, version, gems, local)
      # We can only have different versions of the same Gem, different Gems 
      # is a problem.      
      if gems.collect{|gem| gem.name}.uniq.size > 1
        raise(AmbiguousGemException, "Several different Gems can be found from name #{gemname} (#{gems.collect{|gem| gem.name}.uniq.join(' ')}), please be more specific.") 
      end
      version_gems = Hash[*gems.collect{ |gem| [gem.version.to_s, gem] }.flatten]
      # Latest one will do when no version has been given.
      return [version_gems.sort.reverse[0][1], local] if (version == '*' && !version_gems.empty?)
      return [version_gems[version], local] if (version_gems[version] && !version_gems.empty?)
      nil
    end
  end
  
end

# Shortcut to the dependency task creation.
def dependency(args, &block)
  Raven::DependencyTask.define_task(args, &block)
end
