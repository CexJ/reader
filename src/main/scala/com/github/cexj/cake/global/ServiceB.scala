package com.github.cexj.cake.global

trait ServiceB {
  def getB(i: String): String
}

trait ServiceBProvider {
  final val serviceB: ServiceB = buildServiceB()
  def buildServiceB(): ServiceB
}

class DefaultServiceB()(implicit app: DefaultServiceB.Dependencies) extends ServiceB {
  override def getB(i: String): String = app.serviceC.getC(i+"-B")
}

object DefaultServiceB {
  type Dependencies = ServiceCProvider // <- The dependencies needed for this particular implementation.
}

class DefaultServiceBProvider()(implicit app: ServiceCProvider) extends ServiceBProvider {
  def buildServiceB(): ServiceB = new DefaultServiceB()
}