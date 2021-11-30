package com.github.cexj.reader.hexagonal.infrastructure.repository

import com.github.cexj.reader.hexagonal.core.repository.HStatusRepository
import com.github.cexj.reader.hexagonal.infrastructure.HDB

class HStatusRepositoryImpl(db: HDB) extends HStatusRepository {

  override def getStatus(key: Int): String = db.getStatus(key)

}
