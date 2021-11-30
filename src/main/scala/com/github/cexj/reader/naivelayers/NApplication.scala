package com.github.cexj.reader.naivelayers

import com.github.cexj.reader.naivelayers.infrastructure.NDBImpl
import com.github.cexj.reader.naivelayers.infrastructure.repository.{NStatusRepositoryProviderImpl, NUserManagerProviderImpl}
import com.github.cexj.reader.naivelayers.service.NServiceImpl

object NApplication extends App {

  println(NServiceImpl.findStatus(0).run(NMyApp).run(NDBImpl))

}


object NMyApp
  extends NUserManagerProviderImpl
  with NStatusRepositoryProviderImpl
