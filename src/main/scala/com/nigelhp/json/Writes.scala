package com.nigelhp.json

trait Writes[-A] {
  type JsValue = String

  def writes(a: A): JsValue
}
