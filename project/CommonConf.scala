import sbt._

/**
  * Created by lizhy on 2018/7/11.
  */
object CommonConf {
  val scalaV     = "2.12.6"
  val scalaTestV = "3.0.5"

  val commonDependencies = Seq(
    "org.scalatest" %% "scalatest" % scalaTestV % "test" // http://www.scalatest.org
  )
}
