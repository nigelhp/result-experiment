package com.nigelhp.find.enterprise

import com.nigelhp.domain.Enterprise
import com.nigelhp.domain.Enterprise.Key
import com.nigelhp.find.Finder._

import scala.concurrent.duration._

object EnterpriseFinder {
  def apply(id: Key): FindResult[Enterprise] =
    id match {
      case "nf" => NotFound
      case "to" => Timeout(2.seconds)
      case "boom" => Failed(new Exception("encountered a problem looking up an Enterprise ..."))
      case _ => Found(Enterprise(id))
    }
}
