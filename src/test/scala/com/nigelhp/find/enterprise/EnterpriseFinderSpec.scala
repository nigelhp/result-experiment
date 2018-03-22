package com.nigelhp.find.enterprise

import com.nigelhp.domain.Enterprise
import com.nigelhp.find.Finder.{Failed, Found, NotFound, Timeout}
import org.scalatest.{FreeSpec, Matchers}

import scala.concurrent.duration._

class EnterpriseFinderSpec extends FreeSpec with Matchers {

  "An EnterpriseFinder" - {
    "should return an Enterprise when found" in {
      EnterpriseFinder("xyz") shouldBe Found(Enterprise("xyz"))
    }

    "should return NotFound when there is no matching Enterprise" in {
      EnterpriseFinder("nf") shouldBe NotFound
    }

    "should return Timeout when the find operation times out" in {
      EnterpriseFinder("to") shouldBe Timeout(2.seconds)
    }

    "should return Failed when the lookup fails" in {
      EnterpriseFinder("boom") shouldBe a [Failed]
    }

    "should support pattern matching on the result" in {
      val result = EnterpriseFinder("boom") match {
        case NotFound => "not_found"
        case Found(unitLinks) => s"found_${unitLinks.id}"
        case Timeout(duration) => s"timed_out_after_$duration"
        case Failed(cause) => s"failed_with_cause_$cause"
      }

      println(result)
    }
  }
}
