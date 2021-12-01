package com.github.cexj.cake.global

trait ServiceC {
  def getC(i: String): String
}

trait ServiceCProvider {
  final val serviceC: ServiceC = buildServiceC()
  def buildServiceC(): ServiceC
}

object DefaultServiceC extends ServiceC {
  override def getC(i: String): String = i + "-C"
}

object DefaultServiceCProvider extends ServiceCProvider {
  def buildServiceC(): ServiceC = DefaultServiceC
}

