package com.github.cexj.reader.naivelayers.infrastructure.repository

import cats.data.Reader
import com.github.cexj.reader.naivelayers.infrastructure.NDB

trait NUserRepository {

  def getUser(id: Int): Reader[NDB, Int]
}

object NUserRepositoryImpl extends NUserRepository {

  override def getUser(id: Int): Reader[NDB, Int] = Reader { db: NDB =>
    db.getUser(id)
  }
}

trait NUserManagerProvider {

  def userRepository: NUserRepository
}

trait NUserManagerProviderImpl extends NUserManagerProvider {

  def userRepository: NUserRepository = NUserRepositoryImpl
}