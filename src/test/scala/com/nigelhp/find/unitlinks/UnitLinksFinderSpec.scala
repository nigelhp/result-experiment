package com.nigelhp.find.unitlinks

import com.nigelhp.domain.UnitLinks
import com.nigelhp.find.Finder.{Failed, Found, NotFound, Timeout}
import org.scalatest.{FreeSpec, Matchers}

import scala.Int.MaxValue
import scala.concurrent.duration._

class UnitLinksFinderSpec extends FreeSpec with Matchers {

  "A UnitLinksFinder" - {
    "should return UnitLinks when found" in {
      UnitLinksFinder(1) shouldBe Found(UnitLinks(1))
    }

    "should return NotFound when there are no matching UnitLinks" in {
      UnitLinksFinder(0) shouldBe NotFound
    }

    "should return Timeout when the find operation times out" in {
      UnitLinksFinder(MaxValue) shouldBe Timeout(1.second)
    }

    "should return Failed when the lookup fails" in {
      UnitLinksFinder(-1) shouldBe a [Failed]
    }

    "should support pattern matching on the result" in {
      val result = UnitLinksFinder(3) match {
        case NotFound => "not_found"
        case Found(unitLinks) => s"found_${unitLinks.id}"
        case Timeout(duration) => s"timed_out_after_$duration"
        case Failed(cause) => s"failed_with_cause_$cause"
      }

      println(result)
    }
  }
}
