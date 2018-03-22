package com.nigelhp.find

import com.nigelhp.Handler.handleResult2
import com.nigelhp.domain.{Enterprise, UnitLinks}
import com.nigelhp.find.enterprise.EnterpriseFinder
import com.nigelhp.find.unitlinks.UnitLinksFinder
import org.scalatest.{FreeSpec, Matchers}

import scala.Int.MaxValue

class HandlerSpec extends FreeSpec with Matchers {

  private implicit val writesUnitLinks = UnitLinks.writes
  private implicit val writesEnterprise = Enterprise.writes

  "A Result Handler" - {
    "can handle found UnitLinks" in {
      handleResult2(UnitLinksFinder(3)) shouldBe "Writes[UnitLinks]: UnitLinks(3)"
    }

    "can handle found Enterprise" in {
      handleResult2(EnterpriseFinder("xyz")) shouldBe "Writes[Enterprise]: Enterprise(xyz)"
    }

    "can handle Not Found" in {
      handleResult2(UnitLinksFinder(0)) shouldBe "not found"
      handleResult2(EnterpriseFinder("nf")) shouldBe "not found"
    }

    "can handle Timeout" in {
      handleResult2(UnitLinksFinder(MaxValue)) shouldBe "timed out after 1 second"
      handleResult2(EnterpriseFinder("to")) shouldBe "timed out after 2 seconds"
    }

    "can handle exception" in {
      handleResult2(UnitLinksFinder(-1)) shouldBe "failed because of encountered a problem looking up UnitLinks ..."
      handleResult2(EnterpriseFinder("boom")) shouldBe "failed because of encountered a problem looking up an Enterprise ..."
    }
  }
}
