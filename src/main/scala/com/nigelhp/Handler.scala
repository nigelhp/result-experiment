package com.nigelhp

import com.nigelhp.find.Finder.{Failed, FindResult, Found, NotFound, Timeout}
import com.nigelhp.json.Writes

object Handler {
  def handleResult[A](result: FindResult[A])(writes: Writes[A]): String =
    result match {
      case Found(value) => writes.writes(value)
      case NotFound => "not found"
      case Timeout(duration) => s"timed out after $duration"
      case Failed(cause) => s"failed because of ${cause.getMessage}"
    }

  def handleResult2[A : Writes](result: FindResult[A]): String =
    handleResult(result)(implicitly[Writes[A]])
}
