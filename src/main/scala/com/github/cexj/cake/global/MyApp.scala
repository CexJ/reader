package com.github.cexj.cake.global

object MyApp extends App {
  implicit val serviceCProvider = DefaultServiceCProvider
  implicit val serviceBProvider =  new DefaultServiceBProvider()
  val serviceA = new DefaultServiceA()

  println(serviceA.getA())
}
