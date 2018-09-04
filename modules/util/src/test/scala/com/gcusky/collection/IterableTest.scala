package com.gcusky.collection

import org.scalatest.FunSuite

/**
  * Created by lizhy on 2018/7/26.
  */
class IterableTest extends FunSuite {
  val x1: Iterable[Int]  = 1 to 10000000
  val x2: Iterator[Int]  = x1.toIterator
  val x21: Iterator[Int] = x1.toIterator
  val x22: Iterator[Int] = x1.toIterator
  val x23: Iterator[Int] = x1.toIterator
  val x24: Iterator[Int] = x1.toIterator
  val x25: Iterator[Int] = x1.toIterator
  val x26: Iterator[Int] = x1.toIterator
  val x27: Iterator[Int] = x1.toIterator
  val x28: Iterator[Int] = x1.toIterator
  val x29: Iterator[Int] = x1.toIterator
  val x3: Iterable[Int]  = x2.toIterable

//  test("test toIterator")(x1.toIterator)
//  test("test toIterator2")(x1.iterator)
  /**
    * iterator better
    */
  test("test iterator map")(x21.map(_ * 2)) // Iterator
  test("test iterable map")(x1.map(_ * 2)) // TraversableLike
  test("test seq.view map")(x1.view.map(_ * 2))
  test("test iterator flatMap") { // Iterator
    x22.flatMap(f => if (f % 2 == 0) None else Some(f))
  }
  test("test iterable flatMap") { // TraversableLike
    x1.flatMap(f => if (f % 2 == 0) None else Some(f))
  }
  test("test iterator filter")(x26.filter(_ % 2 == 0)) // Iterator
  test("test iterable filter")(x1.filter(_  % 2 == 0)) // TraversableLike
  test("test iterator find")(x27.find(_ == 10000000)) // Iterator
  test("test iterable find")(x1.find(_ == 10000000)) // IterableLike: toIterator -> find

  /**
    * iterator better
    */
  // all TraversableOnce
  test("test iterator size")(x25.size)
  test("test iterable size")(x1.size)
  // all TraversableOnce
  test("test iterator foldLeft")(x23.foldLeft(0)((a, b) => a + b * 2))
  test("test iterable foldLeft")(x1.foldLeft(0)((a, b) => a + b * 2))

  test("test iterator foldRight")(x28.foldRight(0)((a, b) => a + b * 2))
  test("test iterable foldRight")(x1.foldRight(0)((a, b) => a + b * 2))
  // all TraversableOnce
  test("test iterator sum")(x24.sum)
  test("test iterable sum")(x1.sum)

  test("iterable filter andThen foldLeft")(x1.filter(_  % 3 == 0).foldLeft(0)((a, b) => a + b * 2))
  test("iterator filter andThen foldLeft")(x29.filter(_ % 3 == 0).foldLeft(0)((a, b) => a + b * 2))
}
