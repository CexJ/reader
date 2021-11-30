package com.github.cexj.reader.layers

import com.github.cexj.reader.layers.infrastructure.DBImpl
import com.github.cexj.reader.layers.infrastructure.repository.{StatusRepositoryProviderImpl, UserManagerProviderImpl}
import com.github.cexj.reader.layers.service.ServiceImpl

object Application extends App {

  println(ServiceImpl.findStatus(0).run(MyApp))

}


object MyApp
  extends UserManagerProviderImpl
  with StatusRepositoryProviderImpl
  with DBImpl
