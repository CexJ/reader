package com.github.cexj.reader.hexagonal.infrastructure.repository

import com.github.cexj.reader.hexagonal.core.repository.HUserRepository
import com.github.cexj.reader.hexagonal.infrastructure.HDB

class HUserRepositoryImpl(db: HDB) extends HUserRepository {

  override def getUser(id: Int): Int = db.getUser(id)

}
