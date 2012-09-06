

module Antlr

	class AntlrTask < Rake::Task
		def execute
			puts "This is the lib defined antlr task"
		end
	end

	def antlr(args, &block)
		Antlr::AntlrTask.define_task(args, &block)
	end
end
