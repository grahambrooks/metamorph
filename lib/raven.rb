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

# $:.unshift File.dirname(__FILE__)

#require 'raven/gem_init'
#require 'raven/deps_tasks'
#require 'raven/repo_builder'
require 'raven/java_tasks'
#require 'raven/search_install'
#require 'raven/index_gem_repository'

require 'optparse'

# module Raven
#   module Command
#     def self.run(args)
#       opts = OptionParser.new
#       opts.banner = "Usage: raven [options] (import | repository * | server | install *)"
#       repo_url, proxy_url, index_url, all, groupId, allver = '', '', '', false, nil, false
#       opts.on('-m=ARG', '--mavenrepo repo_url', '[repository] Maven repository to build your gem repository from.') { |val| repo_url = val }
#       opts.on('-p=ARG', '--proxy proxy_url', '[repository|install] Proxy url (http://<p_user>:<p_pwd>@<p_host>:<p_port>) for access outside corporate firewalls.') { |val| proxy_url = val }
#       opts.on('-i=ARG', '--index index_url', '[install] URL of a directory containing repository indices.') { |val| index_url = val }
#       opts.on('-p=ARG', '--project group_id', '[install] Install artifacts in the provided project.') { |val| groupId = val }
#       opts.on('-a', '--all', '[install] Install all selected artifacts.') { |val| all = true }
#       opts.on('-v', '--allversions', '[install] Select all versions, not only the latest.') { |val| allver = true }
      
#       begin
#         rest = opts.parse(*args)
#       rescue ArgumentError
#         puts 'Wrong option.'
#       end
      
#       ARGV.pop while ARGV.length > 0
      
#       case rest[0]
#       when 'import'
#         Raven::MavenLocalRepoImport.run() 
#       when 'repository'
#         if (repo_url.length > 0)
#           puts 'repodef'
#           match = repo_url.match('http://([^/]*)(/.*)')
#           server = match[1]
#           rel_url = match[2]
#           rel_url = rel_url + '/' if rel_url[-1..-1] != '/'
#         else
#           # Use the default maven2 repository.
#           # Info on maven2 mirrors can be found here:
#           #   http://maven.apache.org/guides/mini/guide-mirror-settings.html
#           server = 'repo1.maven.org'
#           rel_url = '/maven2/'
#         end
#         puts "Connecting to Maven2 repository at http://#{server}#{rel_url}."
#         builder = Raven::GemRepoBuilder.new(server, 80, rel_url, Raven::Command.parse_proxy(proxy_url))
#         if (rest.size > 1)
#           rest.shift
#           puts "Packages: #{rest.join(' ')}"
#           builder.group_filters = rest
#         end
#         builder.build
#         main_index(ARGV)
#       when 'server'
#         require 'webrick'
#         include WEBrick
#         s = HTTPServer.new(
#              :Port         => 2233,
#              :DocumentRoot => Dir.pwd )
#         trap("INT") { s.shutdown }
#         s.start
#       when 'install'
#         params = ['raven.rubyforge.org', 80, '/indices/']
#         if (index_url.length > 0)
#           params = Raven::Command.parse_url(index_url)
#           params[2] = '/' if params[2].empty?
#         end
#         params << Raven::Command.parse_proxy(proxy_url)
#         installer = Raven::GemSearchInstaller.new(*params)
#         # Refreshes local gem indices if needed
#         installer.get_indices
        
#         rest.shift
#         rest << '' if (rest.empty? && groupId)
#         rest.each do |artifact| 
#           av = artifact.match(/([^:]*):?(.*)/).to_a
#           # Trock to see if we've been passed a version number or an artifact
#           begin
#             aint = Integer(av[1][0..0])
#             if aint != 0
#               av[2] = av[1]
#               av[1] = ''
#             end
#           rescue
#           end
#           begin
#             installer.install(av[1].length > 0 ? av[1] : nil, 
#                 groupId, av[2].length > 0 ? av[2] : nil, all, allver)
#           rescue GemTooManyInstallError => toomany
#             puts "Couldn't install a gem from name #{av[1]||groupId}, more than one potential"
#             puts "gem was found for this name. If this is intentional and you want to"
#             puts "install all these gems please run again with the --all option."
#             toomany.artifacts.each { |a| puts "   #{a.to_s}"}
#           end
#         end
#       when 'build_index'
#         RepoIndexBuilder.new('m2_central', 'repo1.maven.org', '/maven2/', Raven::Command.parse_proxy(proxy_url)).build_idx
#       else
#         puts opts.to_s
#       end
#     end
    
#     def self.parse_url(url)
#       parsed = /http:\/\/([^\/:]*):?([^\/]*)(\/?.*)/.match(url).to_a
#       parsed.shift
#       parsed
#     end
    
#     def self.parse_proxy(purl)
#       if (purl.length > 0)
#         match = purl.match('http://(.*):(.*)@([^/]*):([0-9]*)')
#         match = match.to_a
#         match.shift
#         puts "Using proxy #{match[2]} and port #{match[3]}"
#         [match[2], match[3].length == 0 ? 80 : Integer(match[3]), match[0], match[1]]
#       else 
#         nil
#       end
#     end
#   end
# end
