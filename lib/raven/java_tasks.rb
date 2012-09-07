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

require 'rake'
require 'fileutils'
require 'set'

# Monkey patching FileUtils to support filtering in copy.
module FileUtils
  class Entry_
    alias original copy
    def copy(dest)
      unless path['.svn'] || path['.cvs']
        original(dest)
      end
    end
  end
end

module Raven
  CP_SEP = File::PATH_SEPARATOR
  
  # Executes Javac by passing it everything it needs. Stuff like a
  # classpath and sources. The classpath is built by checking the
  # prerequisites of the javac task. When a prerequisite is a dependency
  # declaration (dependency task), it takes each declared Gems and
  # adds the jar files found in them to the classpath.
  # 
  # Can be customized by adding directories to the <em>build_path</em>
  # using the << operator (if none defined, default is src/main/java). 
  class JavacTask < Rake::Task
    
    def execute(arg)
      super(arg)
      @classpath = Raven.build_cp(prerequisites)
      @classpath << "target/classes"
      @build_path = ["src/main/java"] unless @build_path
      
      puts "Building path #{@build_path.join(' ')}" if RakeFileUtils.verbose_flag
      
      Dir.mkdir("target") unless File.exist?("target")
      Dir.mkdir("target/classes")  unless File.exist?("target/classes")
      # Getting the source files to compile. Filtrating sources already
      # compiled having a fresh enough class
      source_files = @build_path.collect do |d|
        puts "Warning: build path #{d} doesn't exist!" unless File.exist? d
        Dir.glob("#{d}/**/*.java").select do |java|
          classfile = 'target/classes/' + java[d.length, (java.length - 5 - d.length)] + '.class'
          File.exist?(classfile) ? File.stat(java).mtime > File.stat(classfile).mtime : true
        end
        end.flatten
        
        if (source_files.size > 0)
          # Getting only package names, it shortens the command line
          source_pkg = Set.new
          source_files.each { |src| source_pkg << File.join(File.dirname(src), '*.java') }
          # Executing javac
          puts "javac -classpath \"#{@classpath.join(CP_SEP)}\" -sourcepath \"#{@build_path.join(CP_SEP)}\" -d target/classes #{source_pkg.to_a.join(' ')}" if RakeFileUtils.verbose_flag
          `javac -classpath "#{@classpath.join(CP_SEP)}" -sourcepath "#{@build_path.join(CP_SEP)}" -d target/classes #{source_pkg.to_a.join(' ')}`
          unless $?.exitstatus == 0
            puts "Build failed, see above errors."
            exit
          end
        else
          puts 'All class files are up to date.' if RakeFileUtils.verbose_flag
        end
      end
      
      def build_path
        @build_path ||= []
      end
      
      def build_path=(p)
        @build_path = [p]
      end
    end

    # The JUnit task runs all your test cases located in src/test/java or the
    # build_path that you can set. JUnit inherits from the JavacTask so it 
    # accepts every configuration that JavacTask accepts. In addition you can 
    # add a pattern for your test classes (default pattern is **/Test*.java).
    class JUnitTask < JavacTask
      def execute
        @build_path = ["src/test/java"] unless @build_path
        super
        pattern = (@test_classes.nil? || @test_classes.empty?) ? "**/Test*.java" : @test_classes.first
        tests = @build_path.collect { |d| Dir.glob("#{d}/#{pattern}").collect { |sd| sd[d.size+1..-1] } }
        @test_classes = tests.flatten.collect { |d| d.gsub('/', '.')[0..-6] }
        failures = false
        @test_classes.flatten.each do |tc|
          puts "Running test #{tc}"
          result = `java -classpath "#{@classpath.join(CP_SEP)}" junit.textui.TestRunner #{tc}`
          puts result
          failures = true if /FAILURES/ =~ result || /ERRORS/ =~ result
        end
        if failures
          puts "There were failures!"
          exit(1)
        end
      end

      def test_classes
        @test_classes ||= []
      end
      
      def test_classes=(c)
        @test_classes = [c]
      end
    end
    
    # Builds a jar file from your compiled sources. The jarfile produced
    # will have the same name as your jar task.
    class JarTask < Rake::Task
      def execute
        super
        latest = Raven.latest_file('target/classes')

        # Manifest inclusion
        mfest_param = @manifest ? "-m #{@manifest}" : ""

        if !File.exist?("target/#{name}") || File.stat("target/#{name}").mtime < latest
          `jar -cf target/#{name} #{mfest_param} -C target/classes .`
          puts "Built jar file #{name}." if RakeFileUtils.verbose_flag
        else
          puts 'Nothing to do, jar is fresh enough.' if RakeFileUtils.verbose_flag
        end
      end
    
      def manifest=(f)
        @manifest = f
      end
    end
    
    # Builds a jar file from your sources. Customized by adding directories
    # to the <em>source_path</em> just like the JavacTask.
    class JarSourceTask < Rake::Task
      def execute
        super
        # Checking if any of our prerequisites is a JavacTask, if
        # so we'll just use the build path to construct the jar.
        Raven.prereq_filter(prerequisites, :build_path) do |javac_task|
         (@source_path ||= []) << javac_task.build_path
        end
        
        # Initializing source path
        @source_path = ["src/main/java"] unless @source_path
        @source_path.flatten!
        
        latest = Time.at(0)
        @source_path.each do |dir|
          dir_latest = Raven.latest_file(dir)
          latest = dir_latest if dir_latest > latest
        end
        
        # Manifest inclusion
        mfest_param = @manifest ? "-m #{@manifest}" : ""
        
        # Building the jar from all sources
        if !File.exist?("target/#{name}") || File.stat("target/#{name}").mtime < latest
          `jar -cf target/#{name} #{mfest_param} -C #{@source_path.pop} .`
          while (p = @source_path.pop)
            `jar -uf target/#{name} -C #{p} .`
          end
        end
      end
      
      def source_path
        @source_path ||= []
      end
      
      def manifest=(f)
        @manifest = f
      end
    end
    
    # Produces a WAR from a web application directory. Includes the libraries
    # needed in WEB-INF/lib (as long as the corresponding dependency task is
    # declared as a prerequisite) and the compiled classes (if there are).
    # 
    # Can be customized by setting <em>webapp_dir</em> to the directory
    # containing your web application resources (web.xml, jsp, images, ...).
    # The default is src/main/webapp.
    class WarTask < Rake::Task
      DEFAULT_TARGET = 'target/webapp/'
      LIB_SUBDIR = 'WEB-INF/lib/'
      CLASSES_SUBDIR = 'WEB-INF/classes/'
      
      def execute
        super
        
        # Build target structure
        @webapp_dir = @webapp_dir || 'src/main/webapp'
        Raven.mkdir_recurse(DEFAULT_TARGET)
        
        puts "Using web application directory #{@webapp_dir}" if RakeFileUtils.verbose_flag
        
        FileUtils.cp_r(@webapp_dir, DEFAULT_TARGET)
        
        # Eventually add classes compiled by javac
        if (File.exist?('target/classes'))
          Raven.mkdir_recurse(DEFAULT_TARGET + CLASSES_SUBDIR)
          FileUtils.cp_r('target/classes/.', DEFAULT_TARGET + CLASSES_SUBDIR)
        end
        
        # Make lib directory with all dependencies
        Raven.mkdir_recurse(DEFAULT_TARGET + LIB_SUBDIR)
        Raven.mk_libs(DEFAULT_TARGET + LIB_SUBDIR, prerequisites)
        
        # Build the war
        `jar -cf target/#{name} -C #{DEFAULT_TARGET} .`
      end
      
      def webapp_dir=(param)
        @webapp_dir = param
      end
    end
    
    # Places all the dependencies in a given directory (useful mostly to
    # build a distribution). The dependencies are selected from the 
    # prerequisites (using declared dependency tasks). The  default 
    # directory is lib. Can be customized by setting <em>target</em>.
    class LibDirTask < Rake::Task
      def execute
        super
        puts "Copying libraries in #{@target}" if RakeFileUtils.verbose_flag
        @target = @target || 'lib'
        Raven.mk_libs(@target, prerequisites)
      end
      
      def target=(param)
        @target = param
      end
    end
    
    # Executes JavaDoc by passing it everything it needs. Stuff like a
    # classpath and sources. The result is generated in target/jdoc. Can
    # be customized exactly in the same way as the javac task.
    class JavaDocTask < Rake::Task
      
      def execute
        super
        classpath = Raven.build_cp(prerequisites)
        classpath << "target/classes"
        @build_path = ["src/main/java"] unless @build_path
        
        puts "Executing JavaDoc using source path #{@build_path.join(' ')}" if RakeFileUtils.verbose_flag
        
        Dir.mkdir("target") unless File.exist?("target")
        Dir.mkdir("target/jdoc")  unless File.exist?("target/jdoc")
        
        packages = Set[]
        @build_path.each do |d|
          Dir.glob("#{d}/**/*.java").each do |java| 
            packages << java[(d.length + 1)..(java.rindex('/') - 1)].gsub(%r{[\\/]}, '.')
          end
        end
        packages = packages.to_a
        
        if (packages.size > 0)
          puts "javadoc -classpath #{classpath.join(CP_SEP)} -sourcepath #{@build_path.join(CP_SEP)} -d target/jdoc #{packages.join(' ')}" if RakeFileUtils.verbose_flag
          `javadoc -classpath #{classpath.join(CP_SEP)} -sourcepath #{@build_path.join(CP_SEP)} -d target/jdoc #{packages.join(' ')}`
          unless $?.exitstatus == 0
            puts "Javadoc failed, see above errors."
            exit
          end
        end
      end

      def build_path
        @build_path ||= []
      end

      def build_path=(p)
        @build_path = [p]
      end
    end
    
    # Wraps a jar file around a Gem. Useful for distributing it around.
    # The jar is taken from the target directory. You must at least
    # specify <em>version</em> to produce the Gem. The artifact name and 
    # group name default to the current directory name and its parent 
    # directory name respectively. Convenient if you follow the classic
    # project/module directory structure. Otherwise, just set the
    # <em>artifact</em> and <em>project</em> to any value that suits you.
    class GemWrapTask < Rake::Task
      attr_writer :version, :artifact, :project
      
      def execute
        super
        puts "Wrapping jar in a Gem" if RakeFileUtils.verbose_flag
        unless @version
          puts "A version must be provided to produce a Gem!"
        end
        pwd = Dir.pwd
        @artifact = pwd[(pwd.rindex('/') + 1)..pwd.length] unless @artifact
        pwd = pwd[0..pwd.rindex('/') - 1]
        @group = pwd[(pwd.rindex('/') + 1)..pwd.length] unless @group
        Raven.mkdir_recurse('target/gem/ext')
        FileUtils.cp(Dir.glob('target/*.jar'), 'target/gem/ext')
        
        Dir.chdir('target/gem') do
          spec = Gem::Specification.new do |s|
            s.platform = Gem::Platform::JAVA
            s.summary = "Raven wrapped library #{@artifact} from project #{@group}."
            s.name = "#{@group}-#{@artifact}"
            s.version = @version
            s.requirements << 'none'
            s.require_path = 'ext'
            s.autorequire = 'rake'
            s.files = Dir.glob("{ext}/**/*")
          end
          Gem::Builder.new(spec).build
        end
        FileUtils.mv("target/gem/#{@group}-#{@artifact}-#{@version}-java.gem", 'target')  
      end  
    end
    
    # Wraps a jar file around a Gem and automatically installs it in your
    # local Gem repository. See the gem wrap task for more info (same rules
    # apply).
    class GemInstallTask < GemWrapTask
      def execute
        super
        params = [false]
        params << RAVEN_HOME if defined?(GEMS_IN_HOME)
        Gem::Installer.new("target/#{@group}-#{@artifact}-#{@version}-java.gem").install(*params)
      end
    end
    
    private
    
    # Builds the classpath by getting the path to the jars bundled
    # in each gem dependency.
    def self.build_cp(prerequisites)
      classpath = []
      Raven.prereq_filter(prerequisites, :gem_deps) do |dep_task|
        if (dep_task.gem_deps)
            dep_task.gem_deps.each do |gempath|
            Dir.foreach(gempath + '/ext') do |file|
                next if file == '.' || file == '..'
                classpath << gempath + '/ext/' + file
            end
          end
        end
        if (dep_task.libs)
          classpath.concat(dep_task.libs.flatten)
        end
      end
      classpath
    end
    
    # Copies the jars corresponding to each Gem dependency to a given
    # directory.
    def self.mk_libs(target, prereq)
      Raven.mkdir_recurse(target)
      Raven.prereq_filter(prereq, :gem_deps) do |dep_task|
        if (dep_task.gem_deps)
          dep_task.gem_deps.each do |gempath|
            Dir.foreach(gempath + '/ext') do |file|
              next if file == '.' || file == '..'
              FileUtils.copy(gempath + '/ext/' + file, target)
            end
          end
        end
        if (dep_task.libs)
          dep_task.libs.flatten.each do |libpath|
            FileUtils.copy(libpath, target)
          end
        end
      end
    end

    # Duck typing selection of prerequisites
    def self.prereq_filter(prerequisites, respond_to)
      prerequisites.each do |prereq|
        prereq_task = Rake::Task[prereq]
        if prereq_task.respond_to?(respond_to)
          yield(prereq_task)
        end
      end
    end
    
    # Recursively creates a directory
    def self.mkdir_recurse(dir)
      if dir.rindex('/')
        parent = dir[0, dir.rindex('/')]
        mkdir_recurse(parent) unless File.exist?(parent)
      end
      Dir.mkdir(dir) unless File.exist?(dir)
    end
    
    # Receursively browse a directory yielding on each file found.
    def self.browse_files(root)
      queue = [root]
      while !queue.empty?
        filename = queue.pop
        if File.file?(filename)
          yield(filename)
        else
          Dir.new(filename).each do |child|
            unless ['..', '.', '.svn', '.cvs'].include?(child)
              queue.push(filename + "/" + child)
            end
          end
        end
      end
    end
    
    # Returns the latest file timestamp in a directory structure
    def self.latest_file(dir)
      latest = Time.at(0)
      Raven.browse_files(dir) do |f|
        change = File.stat(f).mtime
        latest = change if change > latest
      end
      latest
    end
    
  end
  
  
  # Shortcut to the Javac task creation. Makes it handy.
  def javac(args, &block)
    puts "Defining javac for #{args}"
    Raven::JavacTask.define_task(args, &block)
  end
  
  # Shortcut to jar. Only 3 letters, isn't that beautiful?
  def jar(args, &block)
    Raven::JarTask.define_task(args, &block)
  end
  
  # I think you've got it now.
  def jar_source(args, &block)
    Raven::JarSourceTask.define_task(args, &block)
  end

  def junit(args, &block)
    Raven::JUnitTask.define_task(args, &block)
  end
  
  def lib_dir(args, &block)
    Raven::LibDirTask.define_task(args, &block)
  end
  
  def war(args, &block)
    Raven::WarTask.define_task(args, &block)
  end
  
  def javadoc(args, &block)
    Raven::JavaDocTask.define_task(args, &block)
  end
  
  def gem_wrap(args, &block)
    Raven::GemWrapTask.define_task(args, &block)
  end
  
  def gem_wrap_inst(args, &block)
    Raven::GemInstallTask.define_task(args, &block)
  end
