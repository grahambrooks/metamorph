package model

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import CodeR.model.ClassSpecification

class ClassSpecificationSpec extends FlatSpec with ShouldMatchers {

  it should "have a name" in {
    val c = new ClassSpecification("foo")

    c.getName should equal("foo")
  }
}
