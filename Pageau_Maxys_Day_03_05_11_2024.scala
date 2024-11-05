// Databricks notebook source
import org.apache.spark.sql.SparkSession

// COMMAND ----------

import org.apache.log4j.{Level, Logger}
Logger.getLogger("org").setLevel(Level.ERROR)

val programStartTime = System.nanoTime()

val logFile = "/FileStore/tables/README.md"
val logData = spark.read.textFile(logFile).cache()

val numSpark = logData.filter(line => line.contains("Spark")).count()
val numScala = logData.filter(line => line.contains("Scala")).count()

println(s"\nLines with word Spark: $numSpark, \nLines with word Scala: $numScala")

val programElapsedTime = (System.nanoTime() - programStartTime) / 1e9
println(s"\nProgram execution time: $programElapsedTime seconds")
println("\n........Program ****Completed**** Successfully.....\n")
