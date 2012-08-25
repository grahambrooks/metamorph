package model

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import CodeR.model.{Statement, Block}

class BlockSpec extends FlatSpec with ShouldMatchers {

  it should "contain statements" in {
    val b = new Block

    b.Add(new Statement {})

    b.IsEmpty should equal(false)
  }
}
