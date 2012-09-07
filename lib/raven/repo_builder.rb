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

require 'net/http'
require 'fileutils'

module Raven

  DIR_EXCL = ['..', '.']
  
  # Representation of a repository artifact. Mostly based on Maven with
  # all the groupId and artifactId crap.
  class Artifact
    attr_reader :groupId, :artifactId, :versionId, :path
    attr_accessor :server
    def initialize(groupId, artifactId, versionId, path)
      @groupId, @artifactId, @versionId, @path = groupId, artifactId, versionId, path
    end

    def to_yaml_properties
      %w{ @groupId @artifactId @versionId @path }
    end
    
    def ==(art) eql?(art); end
    def ===(art) eql?(art); end
    def eql?(art)
      false if art.class != Artifact
      art.groupId == @groupId && art.artifactId == @artifactId && art.versionId == @versionId
    end
    
    def hash
      @groupId.hash ^ (@artifactId.hash << 1) ^ (@versionId.hash << 2)
    end
    
    def to_s
      "#{artifactId} v#{versionId} (project #{groupId})"
    end
  end
  
  # Enumerates on a Maven repository by scraping HTML. Yields on every
  # artifact found in there.
  class Maven2Repository
    EXCLUDE = ["sha1", "md5", "pom"]
    
    attr_writer :group_filters
    
    def group_filters
      @group_filters
    end
    
    def initialize(server, port, url, proxy_info)
      @server, @url, @port, @proxy_info = server, url, port, proxy_info
    end
    
    def each
      if @proxy_info
        http = Net::HTTP::Proxy(*@proxy_info).new(@server, @port)
      else
        http = Net::HTTP.new(@server, @port)
      end
      folder_regexp = /<img src="\/icons\/folder.gif" alt="\[DIR\]"> <a href="[^\/]*\/">/
      file_regexp = /<img src="\/icons\/unknown.gif" alt="\[   \]"> <a href="[^"]*">/
      read_page(http, @url, folder_regexp) do |url1, groupId|
        if @group_filters.nil? || @group_filters.include?(groupId)
          puts "#{groupId}"
          read_page(http, url1 + groupId + '/', folder_regexp) do |url2, artifactId|
            puts "  #{artifactId}"
            read_page(http, url2 + artifactId + '/', folder_regexp) do |url3, versionId|
              puts "    #{versionId}"
              art_path = "#{groupId}/#{artifactId}/#{versionId}/#{artifactId}-#{versionId}.jar"
              artifact = Raven::Artifact.new(groupId, artifactId, versionId, art_path)
              yield(artifact, http)
              
              # Check each file if someday we want to package sources files or javadoc as well...
              # read_page(http, url3 + versionId + '/', file_regexp, 52, 3) do |url4, filename|
              #   type = filename[(filename.rindex('.') + 1)..filename.length]
              # end
            end
          end
        end
      end
    end
    
    def read_page(http, url, regexp, start=51, crop=4)
      response = http.get(url, nil)
      if response.is_a? Net::HTTPSuccess
        response.body.scan(regexp) do |line|
          groupId = line[start..(line.length - crop)]
          yield(url, groupId)
        end
      else
        STDERR.puts "Error connecting to repository: #{response.message}"
        if response.is_a?(Net::HTTPRedirection) && response["location"]
          puts "Location: #{response['location']}"
        else
          puts "------ RESPONSE CODE -----------------------------"
          puts "Response code: #{response.code}"
          puts "------ HEADERS -----------------------------------"
          response.each_header do |key, value|
            puts "#{key}: #{value}"
          end
          puts "------ CONTENT -----------------------------------"
          puts response.body
          puts '-' * 50
        end
      end
    end
  end
  
  class GemRepoBuilder
    attr_writer :group_filters
    
    def initialize(server, port, url, proxy_info)
      @server, @port, @url, @proxy_info = server, port, url, proxy_info
    end
    
    def build(overwrite = false)
      repo = Maven2Repository.new(@server, @port, @url, @proxy_info)
      repo.group_filters = @group_filters unless @group_filters.nil?
      
      Dir.mkdir('gems') unless File.exist?('gems')
      Dir.mkdir('gems/ext') unless File.exist?('gems/ext')
      
      Dir.chdir('gems') do
        repo.each do |artifact, http|
          Raven.install_remote_gem(artifact, http, @url, overwrite)
        end
      end      
      
    end
  end
  
  def self.install_remote_gem(artifact, http, base_url, overwrite=true)
    gemname = "#{artifact.groupId}-#{artifact.artifactId}-#{artifact.versionId}-java.gem"
    if !File.exist?(gemname) || overwrite
      Raven.with(artifact, 'ext', http, base_url) do
        # The fileset is computed when gemspec is created, file must be there
        gemspec = Raven.create_gemspec(artifact)
        Gem::Builder.new(gemspec).build
      end
    end
    gemname
  end

  def self.with(artifact, subdir, http, base_url)
    response = http.get(base_url + artifact.path, nil)
    file = File.new(subdir + "/#{artifact.artifactId}-#{artifact.versionId}.jar", 'wb')
    file.write(response.body)
    file.close
    yield
    File.delete(subdir + "/#{artifact.artifactId}-#{artifact.versionId}.jar")
  end    
    
  class M2LocalRepository
    def initialize(dir)
      @dir = dir
    end
    
    def each_old
      Raven.dir_each(@dir) do |groupId|
        Raven.dir_each(File.join(@dir, groupId)) do |artifactId|
          Raven.dir_each(File.join(@dir, groupId, artifactId)) do |versionId|
            art_path = "#{groupId}/#{artifactId}/#{versionId}/#{artifactId}-#{versionId}.jar"
            artifact = Raven::Artifact.new(groupId, artifactId, versionId, art_path)
            yield(artifact)
          end
        end
      end
    end
    
    def each
      queue = ['']
      while (queue.length > 0)
        path = queue.pop
        # Going down each folder until we find a jar
        Raven.dir_each(File.join(@dir, path)) do |elmt|
          if (File.file?(File.join(@dir, path, elmt)))
            if (elmt[-4..-1] == '.jar')
              # Extracting group, artifact and version from the full path
              c_path = File.join(path, elmt)
              groupNArt = c_path[/^.*\/[0-9]/][1..-3].gsub(File::SEPARATOR, '.')
              groupId = groupNArt[0..(groupNArt.rindex('.') -1)]
              artifactId = groupNArt[(groupNArt.rindex('.') + 1) .. -1]
              v1 = c_path[0..c_path.rindex('/') - 1]
              versionId = v1[v1.rindex('/')+1..-1]
              art_path = "#{groupId.gsub('.', File::SEPARATOR)}/#{artifactId}/#{versionId}/#{artifactId}-#{versionId}.jar"
              artifact = Raven::Artifact.new(groupId, artifactId, versionId, art_path)
              yield artifact
              break
            end
          else
            queue << File.join(path, elmt)
          end
        end
      end
    end
  end
  
  class M1LocalRepository
    def initialize(dir)
      @dir = dir
    end
    
    def each
      Raven.dir_each(@dir) do |groupId|
        if (File.exist?(File.join(@dir, groupId, 'jars')))
          Raven.dir_each(File.join(@dir, groupId, 'jars')) do |filename|
            next if filename[-4, 4] != '.jar'
            begin
              versionId = filename[/-[^a-z].*\.jar/][1..-5]
              artifactId = filename[0..(-versionId.length-6)]
              art_path = "#{groupId}/jars/#{artifactId}-#{versionId}.jar"
              artifact = Raven::Artifact.new(groupId, artifactId, versionId, art_path)
              yield(artifact)
            rescue NoMethodError
              # Will happen if one of the regular expressions return nil
              puts "File #{filename} doesn't seem to be correctly named, ignoring."
            end
          end
        end
      end
    end    
  end
  
  module MavenLocalRepoImport
    def self.run
      # Trying to find out where the local repository is
      maven_home = ENV['MAVEN_HOME'] ? ENV['MAVEN_HOME'] : ''
      repo_home = self.select_repo([maven_home + '/repository', USER_HOME + '/.maven/repository', USER_HOME + '/.m2/repository'])
      if repo_home
        print "Found a Maven repository in #{repo_home}, do you want to use this one? (y/n)"
        puts '' while (!['y', 'n'].include?(answer = gets.chomp))
      end
      repo_home = nil if answer == 'n'
      unless repo_home
        puts "Please provide the path to your maven repository to convert."
        puts "Path doesn't exist! Try again..." while (!File.exist?(repo_home = gets.chomp))
      end
      # Detect the repository type (2 first entries are always . and ..)
      first_subdir = Dir.entries(File.join(repo_home, Dir.entries(repo_home)[2]))[2]
      repo = (first_subdir == 'jars') ? M1LocalRepository.new(repo_home) : M2LocalRepository.new(repo_home)
      
      FileUtils.mkdir('ext') unless File.exist?('ext')
      repo.each do |artifact|
        if File.exist?(File.join(repo_home, artifact.path))
          # Building Gem        
          FileUtils.cp(File.join(repo_home, artifact.path), 'ext')
          gemspec = Raven.create_gemspec(artifact)
          Gem::Builder.new(gemspec).build
          # Installing Gem
          params = [false]
          params << RAVEN_HOME if defined?(GEMS_IN_HOME)
          Gem::Installer.new("#{artifact.groupId}-#{artifact.artifactId}-#{artifact.versionId}-java.gem").install(*params)
          # Cleaning up for next iteration
          FileUtils.rm(Dir.glob('ext/*'))
          FileUtils.rm(Dir.glob('*.gem'))
        else
          puts "File #{artifact.path} couldn't be found, ignoring."
        end
      end
      FileUtils.rm_r('ext')
    end
      
    def self.select_repo(paths)
      paths.each { |p| return p if File.exist?(p) }
      nil
    end
  end
    
  def self.dir_each(path)
    Dir.foreach(path) do |elmt|
      next if DIR_EXCL.include?(elmt)
      yield(elmt)
    end
  end
  
  def self.create_gemspec(artifact)
    spec = Gem::Specification.new do |s|
      s.platform = Gem::Platform::JAVA
      s.summary = "Raven wrapped library #{artifact.artifactId} from project #{artifact.groupId}."
      s.name = "#{artifact.groupId}-#{artifact.artifactId}"
      s.version = artifact.versionId
      s.requirements << 'none'
      s.require_path = 'ext'
      s.autorequire = 'rake'
      s.files = Dir.glob("{ext}/**/*")
    end
  end
  
  class GemTooManyInstallError < RuntimeError
    attr_reader :artifacts    
    def initialize(arts)
      @artifacts = arts
    end
  end
    
end
