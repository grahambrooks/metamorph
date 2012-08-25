package CodeR.model

import collection.mutable


class Block {
  var statements:mutable.MutableList[Statement] = new mutable.MutableList[Statement]()

  def Add(statement: Statement) {
    statements += statement
  }

  def IsEmpty:Boolean = statements.length == 0
}
