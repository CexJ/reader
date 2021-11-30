package com.github.cexj.reader.hexagonal.core.repository

trait HStatusRepository {

  def getStatus(key: Int): String
}




trait HStatusRepositoryProvider {
  def statusRepository: HStatusRepository
}
