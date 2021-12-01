package com.github.cexj.cake.local

object MyApp extends App {

  implicit val serviceBProvider = DefaultServiceBProvider
  val serviceA = new DefaultServiceA()

  println(serviceA.getA())
}
