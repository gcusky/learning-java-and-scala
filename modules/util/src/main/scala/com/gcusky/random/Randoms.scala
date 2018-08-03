package com.gcusky.random

import scala.util.Random

/**
  * Created by lizhy on 2018/8/3.
  */
object Randoms {

  /**
    * 根据权重随机一个元素
    * @param elements    所有元素
    * @param totalWeight elements总权重
    * @param canIndex    如果根据权重随机不到，是否根据索引直接随机
    * @param weigher     获取该元素权重的方法
    * @tparam E          元素类型
    * @return
    */
  def randomOne[E](elements: Iterable[E], totalWeight: Option[Int] = None, canIndex: Boolean = false)(weigher: E => Int): Option[E] = {
    if (elements.isEmpty) return None
    val total = totalWeight.getOrElse(elements.map(weigher).sum)
    if (total > 0) {
      var flag = Random.nextInt(total)
      val it   = elements.iterator
      while (it.hasNext) {
        val next   = it.next()
        val weight = weigher(next)
        if (weight > flag) return Some(next)
        else flag -= weight
      }
    }
    if (!canIndex) return None
    Some(elements.toStream(Random.nextInt(elements.size)))
  }

  /**
    * 根据权重随机n个元素
    * @param elements 所有元素
    * @param n        随机个数
    * @param weigher  获取元素权重的方法
    * @tparam E       元素类型
    * @return
    */
  def random[E](elements: Iterable[E], n: Int)(weigher: E => Int): Iterable[E] = {
    val total = elements.map(weigher).sum
    require(total > 0, "total > 0")
    for (_ <- 0 until n) yield {
      var flag = Random.nextInt(total)
      val it   = elements.iterator
      var one  = null.asInstanceOf[E]
      while (it.hasNext) {
        val next   = it.next()
        val weight = weigher(next)
        if (weight > flag) one = next else flag -= weight
      }
      assert(one != null)
      one
    }
  }
}
