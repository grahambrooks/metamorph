$:.unshift File.dirname(__FILE__)

require 'antlr/antlr_tasks'


def antlr(args, &block)
	Antlr::Antlr3Task.define_task(args, &block)
end

def antlr3(args, &block)
  Antlr::Antlr3Task.define_task(args, &block)
end

def antlr4(args, &block)
  Antlr::Antlr4Task.define_task(args, &block)
end