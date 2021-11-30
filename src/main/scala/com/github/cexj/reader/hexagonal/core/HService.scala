package com.github.cexj.reader.hexagonal.core

import cats.data.Reader
import com.github.cexj.reader.hexagonal.core.repository.{HStatusRepositoryProvider, HUserRepositoryProvider}

trait HService {

  def findStatus(id: Int): Reader[HService.Dependency, String]

}

object HServiceImpl extends HService {
  override def findStatus(id: Int): Reader[HService.Dependency, String] = Reader{ app: HService.Dependency =>
    val key = app.userRepository.getUser(id)
    app.statusRepository.getStatus(key)
  }
}

object HService {

  type Dependency = HStatusRepositoryProvider with HUserRepositoryProvider

}
