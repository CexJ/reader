package com.github.cexj.reader.naivelayers.infrastructure.repository

import cats.data.Reader
import com.github.cexj.reader.naivelayers.infrastructure.NDB


trait NStatusRepository {

  def getStatus(key: Int): Reader[NDB, String]
}


object NStatusRepositoryImpl extends NStatusRepository {

  override def getStatus(key: Int): Reader[NDB, String] = Reader { db: NDB =>
    db.getStatus(key)
  }
}


trait NStatusRepositoryProvider {

  def statusRepository: NStatusRepository
}

trait NStatusRepositoryProviderImpl extends NStatusRepositoryProvider {

  def statusRepository: NStatusRepository = NStatusRepositoryImpl
}