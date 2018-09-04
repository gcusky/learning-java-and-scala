package com.gcusky.collection

import org.scalatest.FunSuite

/**
  * Created by lizhy on 2018/8/7.
  */
class MapValueTest extends FunSuite {

  val x1: Map[Int, Seq[Int]] = (1 to 10000000).groupBy(_ % 2).mapValues(_.map(_ * 2))

  val x2: Map[Int, Seq[Int]] = (1 to 10000000).groupBy(_ % 2).mapValueStrict(_.map(_ * 2))

  val x3: Iterable[Seq[Int]] = (1 to 10000000).groupBy(_ % 2).mapValues(_.map(_ * 2)).values.map(_.map(_ / 2))

  val x4: Iterable[Seq[Int]] = (1 to 10000000).groupBy(_ % 2).mapValueStrict(_.map(_ * 2)).values.map(_.map(_ / 2))

  val y1: Map[Int, Map[Int, Seq[Int]]] = (1 to 10000000).groupBy(_ % 2).mapValueStrict(_.groupBy(_ % 3).mapValues(_.map(_ / 2)))

  val y2: Map[Int, Map[Int, Seq[Int]]] = (1 to 10000000).groupBy(_ % 2).mapValueStrict(_.groupBy(_ % 3).mapValueStrict(_.map(_ / 2)))

  test("mapValue time")(x1.toString)
  test("mapValueStrict time")(x2.toString)

  test("mapValue andThen")(x3.toString)
  test("mapValueStrict andThen")(x4.toString)

  test("mapValueStrict inner mapValues")(y1.toString)
  test("mapValueStrict inner mapValueStrict")(y2.toString)
}
