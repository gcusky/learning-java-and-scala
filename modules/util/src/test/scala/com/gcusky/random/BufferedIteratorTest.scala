package com.gcusky.random

import org.scalatest.FunSuite
import com.gcusky.random.Randoms._

/**
  * Created by lizhy on 2018/8/9.
  */
class BufferedIteratorTest extends FunSuite {

  def cycleTest: Map[Int, Int] = {
    //    val interval   = (1 to 101 by 20).iterator.buffered
    //    val mapBuilder = Map.newBuilder[Int, Int]
    //    def finalOne: Int = randomOneNotEmpty(1 to 100) match {
    //      case x if mapBuilder.result.exists(_._1 == x) => finalOne
    //      case x                                        => x
    //    }
    //    while (interval.hasNext) {
    //      val i = interval.next
    //      val k = interval.headOption
    //      k match {
    //        case Some(j) if j == 101 =>
    //          val keys = randomElements(i until j, 4, distinct = true).iterator
    //          mapBuilder ++= Map(keys.next -> 2, keys.next -> 3, keys.next -> 3, keys.next -> 4)
    //        case Some(j) if j == 81 =>
    //          val keys = randomElements(i until j, 2, distinct = true).iterator
    //          mapBuilder ++= Map(keys.next -> 2, keys.next -> 4)
    //        case Some(j) => mapBuilder += randomOneNotEmpty(i until j) -> 2
    //        case _       => mapBuilder += finalOne -> 1
    //      }
    //    }
    //    mapBuilder.result
    //  }
    ???
  }

  test("println cycleTest")(println(cycleTest))
//  val interval = 1 to 101 by 20
//  test("println interval")(interval.map(println))
}
