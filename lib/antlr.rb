$:.unshift File.dirname(__FILE__)
puts "Loading antlr"


module Antlr
	class AntlrTask < Rake::Task
		attr :grammar, :output_path
		def execute(arg)
			super(arg)
			@output_path = @output_path || "output"
			`java -jar tools/antlr-3.4-complete.jar #{@grammar} -fo #{output_path}`
		end

		def grammar=(grammar_file)
			@grammar = grammar_file
		end

    def output_path=(output_path)
      @output_path = output_path
    end
	end
end

def antlr(args, &block)
	Antlr::AntlrTask.define_task(args, &block)
end
