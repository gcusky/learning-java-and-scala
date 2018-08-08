package com.gcusky

/**
  * Created by lizhy on 2018/8/8.
  */
package object collection {

  implicit def toMapOps[A, B](map: Map[A, B]): MapOps[A, B] = MapOps[A, B](map)
}
