package com.nigelhp.domain

import com.nigelhp.domain.UnitLinks.Key
import com.nigelhp.json.Writes

case class UnitLinks(id: Key)

object UnitLinks {
  type Key = Int

  val writes = new Writes[UnitLinks] {
    override def writes(value: UnitLinks): JsValue =
      s"Writes[UnitLinks]: $value"
  }
}
