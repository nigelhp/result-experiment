package com.nigelhp.find.domain

import com.nigelhp.domain.UnitLinks
import org.scalatest.{FreeSpec, Matchers}

class UnitLinksSpec extends FreeSpec with Matchers {

  "UnitLinks" - {
    "can be written to JSON" in {
      UnitLinks.writes.writes(UnitLinks(42)) shouldBe "Writes[UnitLinks]: UnitLinks(42)"
    }
  }
}
