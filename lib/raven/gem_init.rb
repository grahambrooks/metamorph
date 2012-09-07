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
require 'fileutils'

module Gem
  # Adding Gems Java platform
  module Platform
    JAVA = 'java'
  end
  
  # Unfortunately Maven artifacts have a rather free versioning scheme
  class Version
    def self.correct?(str)
      true
    end
  end
end

begin
  Gem.manage_gems
rescue NoMethodError => ex
  # Using rubygems prior to 0.6.1
end

# Let the user add or redefine his sources (hopefully we'll be
# able to set a default one when a good soul will be able to
# donate us space and bandwidth to host a Raven Gems repository).
module Gem
  def self.sources=(s) 
    @sources = s
  end 
end
if (Gem::RubyGemsPackageVersion != "0.9.0")
  gem("sources")
else
  require_gem("sources")
end
def sources; Gem.sources; end
def set_sources(s) Gem.sources = s; end
set_sources(["http://gems.rubyraven.org/"])

# To avoid polluting the regular Gem repository, we store our gems 
# under the user home directory.
GEMS_IN_HOME = true
USER_HOME = ENV['HOME'] ? ENV['HOME'] : ENV['USERPROFILE'].gsub('\\', '/')
RAVEN_HOME = File.join(USER_HOME, '.raven')
FileUtils.mkdir(RAVEN_HOME) unless File.exist?(RAVEN_HOME)
Dir.glob(File.join(RAVEN_HOME, "specifications", "*.gemspec")).each do |file_name|
  gemspec = Gem::SourceIndex.load_specification(file_name.untaint)
  Gem::cache.add_spec(gemspec) if gemspec
end

module Gem
  # Making the remote installer silent. Otherwise it always asks you to 
  # choose the version you want to install.
  class RemoteInstaller
    if (Gem::RubyGemsPackageVersion != "0.9.0")
      def find_gem_to_install(gem_name, version_requirement)
        specs_n_sources = specs_n_sources_matching gem_name, version_requirement
        # we always give exact name / version to RubyGems
        specs_n_sources.first
      end
    else
      def find_gem_to_install(gem_name, version_requirement, caches)
        specs_n_sources = []
        caches.each do |source, cache|
          cache.each do |name, spec|
            if /^#{gem_name}$/i === spec.name &&
              version_requirement.satisfied_by?(spec.version) then
              specs_n_sources << [spec, source]
            end
          end
        end
        if specs_n_sources.empty? then
          raise GemNotFoundException.new("Could not find #{gem_name} (#{version_requirement}) in the repository")
        end
        specs_n_sources = specs_n_sources.sort_by { |gs,| gs.version }.reverse
        specs_n_sources[0]
      end
    end
  end
end
