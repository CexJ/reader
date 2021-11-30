package com.github.cexj.reader.naivelayers.service

import cats.data.Reader
import com.github.cexj.reader.naivelayers.infrastructure.NDB
import com.github.cexj.reader.naivelayers.infrastructure.repository.{NStatusRepositoryProvider, NUserManagerProvider}

trait NService {

  def findStatus(id: Int): Reader[NService.Dependency, Reader[NDB, String]]

}

object NServiceImpl extends NService {
  override def findStatus(id: Int): Reader[NService.Dependency, Reader[NDB, String]] = Reader{ app: NService.Dependency =>
    for {
      key <- app.userRepository.getUser(id)
      result <- app.statusRepository.getStatus(key)
    } yield result
  }
}

object NService {

  type Dependency = NStatusRepositoryProvider with NUserManagerProvider

}
