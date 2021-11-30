package com.github.cexj.reader.hexagonal.infrastructure

trait HDB {
  def getUser(id: Int): Int
  def getStatus(key: Int): String
}

object HDBImpl extends HDB {
  def getUser(id: Int): Int = id+1
  def getStatus(key: Int): String = s"User #$key: is active"
}
