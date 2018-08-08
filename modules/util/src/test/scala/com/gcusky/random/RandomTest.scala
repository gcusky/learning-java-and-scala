package com.gcusky.random

import org.scalatest.FunSuite

import com.gcusky.random.Randoms._
// import scala.util.Random

/**
  * Created by lizhy on 2018/8/3.
  */
class RandomTest extends FunSuite {

  //Map("1.1" -> 1, "1.2" -> 1, "1.3" -> 4, "1.4" -> 1, "1.5" -> 1, "1.6" -> 3, "1.7" -> 1, "1.8" -> 2, "1.9" -> 1, "2.1" -> 1, "2.2" -> 1)
  val testMap: Iterable[TestWeight] =
    Map(
      "1.1" -> 88,
      "1.2" -> 88,
      "1.3" -> 4,
      "1.4" -> 1,
      "1.5" -> 1,
      "1.6" -> 3,
      "1.7" -> 1,
      "1.8" -> 2,
      "1.9" -> 1,
      "2.1" -> 1,
      "2.2" -> 1).map(f => TestWeight.apply(f._1, f._2))

//  def randomOne[E](elements: Iterable[E], totalWeight: Option[Int] = None, canIndex: Boolean = false)(weigher: E => Int): Option[E] = {
//    if (elements.isEmpty) return None
//    val total = totalWeight.getOrElse(elements.map(weigher).sum)
//    if (total > 0) {
//      var flag = Random.nextInt(total)
//      val it   = elements.iterator
//      while (it.hasNext) {
//        val next   = it.next()
//        val weight = weigher(next)
//        if (weight > flag) return Some(next)
//        else flag -= weight
//      }
//    }
//    if (!canIndex) return None
//    Some(elements.toStream(Random.nextInt(elements.size)))
//  }
//
//  def random[E](elements: Iterable[E], n: Int)(weigher: E => Int): Iterable[E] = {
//    val total = elements.map(weigher).sum
//    require(total > 0, "total > 0")
//    for (_ <- 0 until n) yield {
//      var flag = Random.nextInt(total)
//      val it   = elements.iterator
//      var one  = null.asInstanceOf[E]
//      while (it.hasNext) {
//        val next   = it.next()
//        val weight = weigher(next)
//        if (weight > flag) one = next else flag -= weight
//      }
//      assert(one != null)
//      one
//    }
//  }

  case class TestWeight(value: String, weight: Int) { def getWeight: Int = weight }

  test("random one") {
    val one = randomOne(testMap)(_.getWeight)
    print(one)
    assert(one.isDefined, "has one")
  }

  test("random all") {
    val list = random(testMap, 6)(_.getWeight)
    println(list)
    assert(list.nonEmpty, "has all")
  }
}
