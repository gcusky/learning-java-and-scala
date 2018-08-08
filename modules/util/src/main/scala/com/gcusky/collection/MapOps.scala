package com.gcusky.collection

/**
  * Created by lizhy on 2018/8/8.
  */
case class MapOps[A, B](underlying: Map[A, B]) {

  /**
    * mapValue return a map view, mapValueStrict return a new map
    */
  def mapValueStrict[W](f: B => W): Map[A, W] = {
    val builder = Map.newBuilder[A, W]
    underlying.foreach(g => builder += g._1 -> f(g._2))
    builder.result
  }
}
