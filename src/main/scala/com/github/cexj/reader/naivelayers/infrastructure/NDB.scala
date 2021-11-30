package com.github.cexj.reader.naivelayers.infrastructure

trait NDB {
  def getUser(id: Int): Int
  def getStatus(key: Int): String
}

object NDBImpl extends NDB {
  def getUser(id: Int): Int = id+1
  def getStatus(key: Int): String = s"User #$key: is active"
}
