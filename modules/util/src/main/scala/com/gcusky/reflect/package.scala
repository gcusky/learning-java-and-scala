package com.gcusky

import org.reflections.Reflections

/**
  * Created by lizhy on 2018/4/18.
  */
package object reflect {
  val reflection = new Reflections("com.gcusky.reflect") // 包名，反射的范围

  implicit def toClassOps[T1](clazz: Class[T1]): ClassOps[T1] = ClassOps(clazz) // clazz 类类型
  implicit def toModifierOps(mod: Int): ModifierOps           = ModifierOps(mod)
}
