package com.nigelhp.find.domain

import com.nigelhp.domain.Enterprise
import org.scalatest.{FreeSpec, Matchers}

class EnterpriseSpec extends FreeSpec with Matchers {

  "An Enterprise" - {
    "can be written to JSON" in {
      Enterprise.writes.writes(Enterprise("some-id")) shouldBe "Writes[Enterprise]: Enterprise(some-id)"
    }
  }
}
