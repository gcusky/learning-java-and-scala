name := "learning"

lazy val commonSetting = Seq(
  version := "0.1",
  scalaVersion := CommonConf.scalaV
)

libraryDependencies ++= CommonConf.commonDependencies

resolvers += Resolver.sonatypeRepo("snapshots")

lazy val util = (project in file("modules/util")).settings(commonSetting)

lazy val concurrent = (project in file("modules/concurrent")).settings(commonSetting)

lazy val root = (project in file(".")).aggregate(util, concurrent).dependsOn(util, concurrent)