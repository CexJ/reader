package com.github.cexj.reader.hexagonal

import com.github.cexj.reader.hexagonal.core.HServiceImpl
import com.github.cexj.reader.hexagonal.core.repository.{HStatusRepository, HStatusRepositoryProvider, HUserRepository, HUserRepositoryProvider}
import com.github.cexj.reader.hexagonal.infrastructure.HDBImpl
import com.github.cexj.reader.hexagonal.infrastructure.repository.{HStatusRepositoryImpl, HUserRepositoryImpl}

object HApplication extends App {

  println(HServiceImpl.findStatus(0).run(HMyAppImpl))

}

object HMyAppImpl
  extends HStatusRepositoryProvider
  with HUserRepositoryProvider {

  override def statusRepository: HStatusRepository = new HStatusRepositoryImpl(HDBImpl)

  override def userRepository: HUserRepository = new HUserRepositoryImpl(HDBImpl)
}
