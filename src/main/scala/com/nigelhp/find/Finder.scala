package com.nigelhp.find

import scala.concurrent.duration.Duration

object Finder {
  sealed trait FindResult[+A]

  case class Found[+A](value: A) extends FindResult[A]
  case object NotFound extends FindResult[Nothing]
  case class Timeout(after: Duration) extends FindResult[Nothing]
  case class Failed(cause: Exception) extends FindResult[Nothing]
}
