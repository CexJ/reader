package com.github.cexj.cake.local

trait ServiceC {
  def getC(i: String): String
}

trait ServiceCProvider {
  final val serviceC: ServiceC = buildServiceCManager()
  def buildServiceCManager(): ServiceC
}

object DefaultServiceC extends ServiceC {
  override def getC(i: String): String = i + "-C"
}

object DefaultServiceCProvider extends ServiceCProvider {
  def buildServiceCManager(): ServiceC = DefaultServiceC
}
