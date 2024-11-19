// Databricks notebook source
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object UserAnalysis {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("User Analysis")
      .getOrCreate()

    import spark.implicits._

    val filePath = "FilesStore/tables/data.csv"
    val data = spark.read
      .option("header", "true") 
      .option("inferSchema", "true")
      .csv(filePath)

    // Filtrer les utilisateurs ayant au moins 25 ans
    val usersOver25 = data.filter($"age" >= 25)
    println("Utilisateurs âgés de 25 ans et plus :")
    usersOver25.show()

    // Extraire les noms et les villes
    val namesAndCities = data.select($"name", $"city")
    println("Noms et villes :")
    namesAndCities.show()

    // Grouper les utilisateurs par ville
    val groupedByCity = data.groupBy($"city").agg(collect_list($"name").as("users"))
    println("Utilisateurs groupés par ville :")
    groupedByCity.show(truncate = false)

    spark.stop()
  }
}

