package com.github.cexj.cake.local

trait ServiceA {
  def getA(): String
}

class DefaultServiceA()(implicit app: DefaultServiceA.Dependencies) extends ServiceA {
  override def getA(): String = app.serviceB.getB("A")
}

object DefaultServiceA {
  type Dependencies = ServiceBProvider
}


