package com.github.cexj.reader.layers.service

import cats.data.Reader
import com.github.cexj.reader.layers.infrastructure.DB
import com.github.cexj.reader.layers.infrastructure.repository.{StatusRepositoryProvider, UserManagerProvider}
import com.github.cexj.reader.layers.service.Service.Dependency

trait Service {

  def findStatus(id: Int): Reader[Dependency, String]

}

object ServiceImpl extends Service {
  override def findStatus(id: Int): Reader[Dependency, String] = Reader{ app: Dependency =>
    for {
      key <- app.userRepository.getUser(id)
      result <- app.statusRepository.getStatus(key)
    } yield result
  }.flatMap(_.local(identity))
}

object Service {

  type Dependency = StatusRepositoryProvider with UserManagerProvider with DB

}
