package com.github.cexj.reader.hexagonal.core.repository

trait HUserRepository {

  def getUser(id: Int): Int
}



trait HUserRepositoryProvider {
  def userRepository: HUserRepository
}
