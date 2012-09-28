module Antlr
	class AntlrTask < Rake::Task
		attr :grammar, :output_path
		def grammar=(grammar_file)
			@grammar = grammar_file
		end

    def output_path=(output_path)
      @output_path = output_path
    end
    
    def tool_path
      File.join(project_path, 'tools')
    end
    
    def project_path
      File.absolute_path(File.join(File.dirname(__FILE__), '..', '..'))
    end      
    
    def exec(cmd)
      puts cmd
      print `#{cmd}`
    end
	end
	
	class Antlr3Task < AntlrTask
		def execute(arg)
			super(arg)
			@output_path = @output_path || "output"
			exec "java -jar tools/antlr-3.4-complete.jar #{@grammar} -fo #{output_path}"
		end

  end
	
	class Antlr4Task < AntlrTask
		def execute(arg)
			super(arg)
			@output_path = File.join(project_path, @output_path) || "output"
			grammar_path = File.dirname(@grammar)
      exec "cd #{grammar_path};java -jar #{tool_path}/antlr-4.0b1-complete.jar #{File.basename(@grammar)} -o #{output_path} -visitor"
			# exec "cd #{grammar_path};java -jar #{tool_path}/antlr-4.0b1-complete.jar #{File.basename(@grammar)} -visitor"
		end
  end
end
