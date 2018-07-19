package com.gcusky.reflect

import scala.collection.JavaConverters._
import scala.reflect.runtime.universe

/**
  * Created by lizhy on 2018/4/16.
  */
case class ClassOps[T](underlying: Class[T]) {

  /**
    * 获取所有的子类（不包括抽象类/接口）
    */
  def subTypes: List[Class[_ <: T]] = {
    val subTypes = reflection.getSubTypesOf(underlying).asScala // 扫描
    subTypes.view.filterNot(c => c.getModifiers.isAbstract).toList
  }

  /**
    * 获取所有的子类（包括抽象类/接口）
    */
  def allSubTypes: List[Class[_ <: T]] = reflection.getSubTypesOf(underlying).asScala.toList

  /**
    * 获取该类的单例对象
    */
  @throws[IllegalStateException]("if not singleton object")
  def singleton: T =
    try {
      underlying.getField("MODULE$").get(null).asInstanceOf[T] // 实例对象
    } catch {
      case _: NoSuchFieldException => throw new IllegalStateException(s"${underlying.getName} is NOT a object")
    }

  /**
    * 获取所有子单例对象
    */
  def subSingletons: Seq[T] = subTypes.view.filterNot(c => c.isLocalClass || c.isAnonymousClass || c.isMemberClass).map(_.singleton).toList

  /**
    * 获取该类的伴生对象
    */
  def companion: AnyRef = {
    val mirror = universe.runtimeMirror(underlying.getClassLoader) // universe -> mirror
    val module = mirror.classSymbol(underlying).companion.asModule // mirror + classSymbol -> companion -> moduleSymbol
    mirror.reflectModule(module).instance.asInstanceOf[AnyRef] // mirror + moduleSymbol -> instance
  }
}
