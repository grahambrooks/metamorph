$:.unshift File.dirname(__FILE__)
puts "Loading antlr"


module Antlr
	class AntlrTask < Rake::Task
		attr :grammar
		def execute(arg)
			super(arg)
			`java -jar tools/antlr-3.4-complete.jar #{@grammar}`
		end

		def grammar=(grammar_file)
			@grammar = grammar_file
		end


	end
end

def antlr(args, &block)
	Antlr::AntlrTask.define_task(args, &block)
end
