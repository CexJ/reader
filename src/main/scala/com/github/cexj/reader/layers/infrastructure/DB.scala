package com.github.cexj.reader.layers.infrastructure

trait DB {
  def getUser(id: Int): Int
  def getStatus(key: Int): String
}

trait DBImpl extends DB {
  def getUser(id: Int): Int = id+1
  def getStatus(key: Int): String = s"User #$key: is active"
}
