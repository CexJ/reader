package com.github.cexj.reader.layers.infrastructure.repository

import cats.data.Reader
import com.github.cexj.reader.layers.infrastructure.DB

trait UserRepository {

  def getUser(id: Int): Reader[DB, Int]
}

object UserRepositoryImpl extends UserRepository {

  override def getUser(id: Int): Reader[DB, Int] = Reader { db: DB =>
    db.getUser(id)
  }
}

trait UserManagerProvider {

  def userRepository: UserRepository
}

trait UserManagerProviderImpl extends UserManagerProvider {

  def userRepository: UserRepository = UserRepositoryImpl
}