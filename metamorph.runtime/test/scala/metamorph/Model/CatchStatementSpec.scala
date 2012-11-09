package metamorph.Model

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import metamorph.model.CatchStatement

class CatchStatementSpec extends FlatSpec with ShouldMatchers {
  it should "know if it's block is empty" in {
    val catchStatement = new CatchStatement

    catchStatement.block.IsEmpty should equal(true)
  }


}
