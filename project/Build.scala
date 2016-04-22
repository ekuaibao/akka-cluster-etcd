import sbt._
import sbt.Keys._

object Settings extends sbt.Build {

  import com.typesafe.sbt.SbtScalariform.ScalariformKeys

  val scalariformPrefs = {
    import java.util.Properties
    import scalariform.formatter.preferences._
    val props = new Properties()
    IO.load(props, file("scalariform.properties"))
    PreferencesImporterExporter.getPreferences(props)
  }

  lazy val commonSettings = Seq(
    version := "0.1.0",
    organization := "pl.caltha",
    scalaVersion := "2.11.7",
    ScalariformKeys.preferences := scalariformPrefs
  )
}