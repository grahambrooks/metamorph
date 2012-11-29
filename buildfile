# Generated by Buildr 1.4.9, change to your liking
require 'buildr/scala'

task :grammar do

end



project_layout = Layout.new
project_layout[:source, :main, :java] = 'src/java'
project_layout[:source, :main, :scala] = 'src/scala'

# Version number for this release
VERSION_NUMBER = "1.0.0"
# Group identifier for your projects
GROUP = "metamorph.common"
COPYRIGHT = ""

# Specify Maven 2.0 remote repositories here, like this:
repositories.remote << "http://repo1.maven.org/maven2"

desc "The Metamorph.common project"
define "metamorph.common", :layout => project_layout do

  project.version = VERSION_NUMBER
  project.group = GROUP
  manifest["Implementation-Vendor"] = COPYRIGHT
  package :jar

end
