module Component
  CP_SEP = File::PATH_SEPARATOR

  class ComponentTask < Rake::Task

    def execute(arg)
      super(arg)
    end

    def compile_and_jar(args)
      antlr4(args)
      javac(args)
      scalac(args)
      jar(args)
      cleanup(args)
    end

    def cleanup(args)
      target_path = File.join(name, "build", "classes")
      FileUtils.remove_dir(target_path)
    end

    def antlr4(args)
      return unless args[:antlr4]
      output_path = File.absolute_path(File.join(name, args[:java], 'CodeR.Java'))
      grammar_path = File.dirname(File.join(name, args[:antlr4]))
      exec "cd #{grammar_path};java -jar #{tool_path}/antlr-4.0b1-complete.jar #{File.basename(args[:antlr4])} -o #{output_path} -visitor"
    end
    
    def scalac(args)
      return unless args[:scala]
      
      src_path = args[:scala]
      if src_path
        files = []
        search_path = File.join(name, src_path, "**", "*.scala")
        puts "Scanning for scala source files #{search_path}"
        Dir.glob(search_path) do |scala_file_path|
          files << scala_file_path
        end
        
        exec "~/lib/scala-2.9.2/bin/scalac -d #{args[:jar_file]} #{files.join(' ')}"
      end
    end

    def javac(args)
      return unless args[:java]
      
      build_path = [File.join(name, args[:java])]
      target_path = File.join(name, "build", "classes")
      FileUtils.makedirs(target_path)

      files = []
      build_path.each do |path|
        Dir.glob(File.join(path, '**/*.java')) do |file_path|
          files << file_path
        end
      end

      exec "javac -classpath \"#{classpath(args).join(CP_SEP)}\" -sourcepath \"#{build_path.join(CP_SEP)}\" -d #{target_path} #{files.join(' ')}"
    end

    def jar(args)
      return if args[:scala]
      jar_file = args[:jar_file]
      jar_folder = File.join(name, 'build', 'jar')
      FileUtils.makedirs(jar_folder)
      target_path = File.join(name, "build", "classes")
      exec "jar -cf #{jar_folder}/#{jar_file} -C #{target_path} ."
    end

    def classpath(args)
      cp = []
      args[:libs].each do |entry|
        puts entry
        if File.directory?(entry) then
          Dir.glob(File.join(entry, '**/*.jar')) do |jar_path|
            cp << jar_path
          end
        else
          cp << entry
        end
      end
      cp
    end

    def exec(cmd)
      puts cmd
      print `#{cmd}`
    end

    def tool_path
      File.join(project_path, 'tools')
    end

    def project_path
      File.absolute_path(File.join(File.dirname(__FILE__), '..'))
    end      
  end
end

def component(args, &block)
  Component::ComponentTask.define_task(args, &block)
end
