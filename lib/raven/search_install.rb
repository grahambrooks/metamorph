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

module Raven

  class RepoIndexBuilder
    def initialize(name, server, base_url, port, proxy_info)
      @name, @server, @base_url, @port, @proxy_info = name, server, base_url, port, proxy_info
    end
    
    def build_idx
      require 'yaml'
      require 'zlib'
      Zlib::GzipWriter.open("#{@name}.mvnidx.gz") do |f|
        f << @server + "#" + @port + "#" + @base_url + "\n"
        Raven::Maven2Repository.new(@server, @base_url, @port, @proxy_info).each do |artifact, http|
          f << YAML.dump(artifact)
        end
      end
    end
  end
  
  class GemSearchInstaller
    def initialize(server, port, base_url, proxy_info)
      @server, @base_url, @port, @proxy_info = server, base_url, port, proxy_info
    end
    
    def list_indices
      indices = []
      if @proxy_info
        http = Net::HTTP::Proxy(*@proxy_info).new(@server, @port)
      else
        http = Net::HTTP.new(@server, @port)
      end
      response = http.get(@base_url, nil)
      expr = /href="([^"]*idx.gz)"|HREF="([^"]*idx.gz)"/
      if response.message.strip == "OK"
        response.body.each_line do |line|
          if expr =~ line
            indices << expr.match(line)[1]
          end
        end
      else
        puts "Got a bad response from server http://#{@server}:#{@port}/#{@base_url}, couldn't update local index"
      end
      indices
    end
    
    def get_indices
      require 'stringio'
      if @proxy_info
        http = Net::HTTP::Proxy(*@proxy_info).new(@server, @port)
      else
        http = Net::HTTP.new(@server, @port)
      end
      
      list_indices.each do |file|
        http_fn, fs_fn = @base_url + file, File.join(RAVEN_HOME, file[0..-4])
        
        # Checking file size to see if it changed
        header = http.head(http_fn)
        zipsize = header["content-length"]
        oldsize = File.exist?(fs_fn) ? File.new(fs_fn).readline.chomp : '0'
        
        unless (zipsize.to_i == oldsize.to_i)
          puts "Refreshing index file #{file[0..-4]}"
          response = StringIO.new(http.get(@base_url + file, nil).body)
          zlib = Zlib::GzipReader.new(response)
          file = File.new(File.join(RAVEN_HOME, file[0..-4]), 'wb')
          file << zipsize + "\n"
          file.write(zlib.read)
          file.close
          zlib.close
        end
      end
    end
    
    def search(artifactId, groupId=nil, versionId=nil)
      idx_files = Dir[File.join(RAVEN_HOME, '*.mvnidx')]
      found = []
      idx_files.each do |idx_file|
        puts "Searching in #{idx_file}..."
        f = File.new(idx_file)
        found.concat(search_index(f, artifactId, groupId, versionId))
      end
      found
    end
    
    def search_index(idx_file, artifactId, groupId, versionId)
      # Removing gz file size header
      idx_file.gets
      # Getting server name and gz file size header
      server_addr = idx_file.gets.chomp.split("#")
      aid_line = /artifactId: (.*#{artifactId}.*)/
      aidx_line = /artifactId: (#{artifactId})$/
      gid_line = /groupId: (.*#{groupId}.*)/
      vid_line = /versionId: "?(#{versionId})"?/

      # a, a+v, a+g, g, v+g, a+v+g
      found = []
      exact_match = false
      while (lines = read_lines(idx_file, 5))
        ma, mg, mv = false, false, false
        ma = lines[2].strip =~ aid_line if artifactId
        mg = lines[1].strip =~ gid_line if groupId
        mv = lines[3].strip =~ vid_line if versionId
        if ((ma && groupId.nil? && versionId.nil?) ||
            (ma && mg && versionId.nil?) ||
            (ma && mv && groupId.nil?) ||
            (ma && mg && mv) ||
            (mg && mv && artifactId.nil?) ||
            (mg && artifactId.nil? && versionId.nil?))
          artifact = YAML.load(lines.join("\n"))
          artifact.server = server_addr
          # We have an exact match, the rules change, only other exact matches 
          # get selected
          if lines[2].strip =~ aidx_line
            unless exact_match
             exact_match = true
             found = []
            end
            found << artifact
          end           
          found << artifact unless exact_match
        end
      end
      found
    end
    
    def read_lines(file, size)
      lines = []
      0.upto(size-1) { |m| lines[m] = file.gets }
      return nil if lines[size-1].nil?
      lines
    end
  
    def install(artifactId, groupId, versionId, all=false, all_versions=false)
      artifacts = search(artifactId, groupId, versionId).uniq
      
      if (versionId.nil? && !all_versions)
        artifacts = filtrate_latest(artifacts)
      end
      
      # Selected several artifacts but supposed to have only one
      if (artifacts.nil?)
        puts "Gem indices couldn't be found properly (either you provided a wrong URL or the main site is down)."
        return
      end
      raise GemTooManyInstallError.new(artifacts) if (!all && artifacts.size > 1)
      
      if (artifacts.empty?)
        puts "Nothing found."
      else
        # TODO install from the servers returned by search
        # Proceeding with installation
        FileUtils.mkdir('ext') unless File.exist?('ext')
        puts "Installing Gems:"
        artifacts.each do |artifact|
          if @proxy_info
            http = Net::HTTP::Proxy(*@proxy_info).new(artifact.server[0], artifact.server[1])
          else
            http = Net::HTTP.new(artifact.server[0], Integer(artifact.server[1]))
          end        
          puts "  - #{artifact.to_s}"
          gemname = Raven.install_remote_gem(artifact, http, artifact.server[2], true)
          params = [false]
          params << RAVEN_HOME if defined?(GEMS_IN_HOME)
          Gem::Installer.new(gemname).install(*params)      
          FileUtils.rm(gemname)
        end
        FileUtils.rm_rf('ext')
      end
    end
    
    def filtrate_latest(artifacts)
      # Create a hash with all versions of each artifact
      arth = {}
      artifacts.each do |art| 
        key = "#{art.groupId}%#{art.artifactId}"
        arth[key] ||= []
        arth[key] << Version.new(art.versionId)
      end
      
      arth.keys.collect do |key|
        last_ver = arth[key].sort[-1].version
        find_artifact(artifacts, *(key.split('%') << last_ver))
      end
    end
    
    def find_artifact(artifacts, groupId, artifactId, versionId)
      artifacts.select do |art|
        art if art.artifactId == artifactId && 
                art.groupId == groupId && art.versionId == versionId
      end[0]
    end
  end
  
  # Structured version class used to try to make some sense
  # out of Maven version numbers. A difficult task indeed.
  class Version
    include Comparable
    attr_reader :timestamp, :ver_struct, :version
    
    def initialize(version)
      @version = version
      elmts = @version.split(/\.|-/)
      @timestamp = elmts[0].length > 3 ? true : false
      @ver_struct = elmts.collect do |elmt|
        val = ''
        begin
          val = Integer(elmt)
        rescue ArgumentError
          val = elmt
        end
        val
      end
    end
    
    def <=>(ver)
      false if !(Version === ver)
      return -1 if @timestamp && !ver.timestamp
      return 1 if !@timestamp && ver.timestamp
      # Adding 0 to the end of the shortest one to get the same
      # size, JRuby considers size first (even if size doesn't 
      # always matter)
      @me, you = @ver_struct.dup, ver.ver_struct.dup
      if (@me.size != you.size)
        shorty = @me.size > you.size ? you : @me
        biggy = @me.size > you.size ? @me : you
        (shorty.size..biggy.size-1).each { |m| shorty[m] = 0 }
      end
      # Setting string elements to 0 (mostly weaker) if they need
      # to be compared to an int otherwise <=> could produce nil
      (0..@me.size).each do |m|
        if (m < you.size && @me[m].class != you[m].class)
          @me[m] = 0 if String === @me[m]
          you[m] = 0 if String === you[m]
        end
      end
      @me <=> you
    end
    
    def to_s
      puts "v#{@version}, ts #{timestamp}, #{ @ver_struct.collect{ |v| v.class }.join('/') }"
    end
  end
  
end
