package com.github.cexj.reader.layers.infrastructure.repository

import cats.data.Reader
import com.github.cexj.reader.layers.infrastructure.DB


trait StatusRepository {

  def getStatus(key: Int): Reader[DB, String]
}


object StatusRepositoryImpl extends StatusRepository {

  override def getStatus(key: Int): Reader[DB, String] = Reader { db: DB =>
    db.getStatus(key)
  }
}


trait StatusRepositoryProvider {

  def statusRepository: StatusRepository
}

trait StatusRepositoryProviderImpl extends StatusRepositoryProvider {

  def statusRepository: StatusRepository = StatusRepositoryImpl
}