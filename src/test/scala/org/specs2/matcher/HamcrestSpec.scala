package org.specs2
package matcher

import org.hamcrest._
import specification._

class HamcrestSpec extends script.Specification with Grouped with Hamcrest { def is = s2"""

  Hamcrest matchers can be used as specs2 matchers by mixing in the Hamcrest trait      
  + for example a beEven hamcrest matcher can be used in a 'must' expression
    + the failure message must contain the matched value and the hamcrest failure message
                                                                                           """

  new g1 {
    e1 := 2 must beEven
    e2 := (3 must beEven).message === "<3> is odd"
  }

  // a Hamcrest matcher for even numbers
  object beEven extends BaseMatcher[Int] {
    def matches(item: Object): Boolean       = item.toString.toInt % 2 == 0
    def describeTo(description: Description) { description.appendText(" is odd") }
  }

}
