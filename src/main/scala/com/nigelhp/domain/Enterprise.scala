package com.nigelhp.domain

import com.nigelhp.domain.Enterprise.Key
import com.nigelhp.json.Writes

case class Enterprise(id: Key)

object Enterprise {
  type Key = String

  val writes = new Writes[Enterprise] {
    override def writes(value: Enterprise): JsValue =
      s"Writes[Enterprise]: $value"
  }
}
