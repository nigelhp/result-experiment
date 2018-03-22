package com.nigelhp.find.unitlinks

import com.nigelhp.domain.UnitLinks
import com.nigelhp.domain.UnitLinks.Key
import com.nigelhp.find.Finder._

import scala.Int.MaxValue
import scala.concurrent.duration._

object UnitLinksFinder {
  def apply(id: Key): FindResult[UnitLinks] =
    id match {
      case -1 => Failed(new Exception("encountered a problem looking up UnitLinks ..."))
      case  0 => NotFound
      case  MaxValue => Timeout(1.second)
      case  n => Found(UnitLinks(n))
    }
}
