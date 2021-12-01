package com.github.cexj.cake.local

trait ServiceB {
  def getB(i: String): String
}

trait ServiceBProvider {
  final val serviceB: ServiceB = buildServiceBManager()
  def buildServiceBManager(): ServiceB
}

class DefaultServiceB()(implicit app: DefaultServiceB.Dependencies) extends ServiceB {
  println(app) // <- why this is NULL ???

  override def getB(i: String): String = app.serviceC.getC(i+"-B")

}

object DefaultServiceB {
  type Dependencies = ServiceCProvider // <- The dependencies needed for this particular implementation.
}

object DefaultServiceBProvider extends ServiceBProvider {
  implicit val serviceCProvider: ServiceCProvider = DefaultServiceCProvider
  def buildServiceBManager(): ServiceB = new DefaultServiceB()(serviceCProvider)
}