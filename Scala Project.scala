// Databricks notebook source
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import com.mongodb.spark._
import com.mongodb.spark.config._
import com.mongodb.spark.sql._

// Créer une session Spark
val spark = SparkSession.builder()
  .appName("Databricks JSON to MongoDB")
  .getOrCreate()

// Chemins des fichiers JSON dans Databricks
val filePath2023 = "/FileStore/tables/nvdcve_1_1_2023-3.json"
val filePath2024 = "/FileStore/tables/nvdcve_1_1_2024-3.json"

// Lire les fichiers JSON dans des DataFrames
val df2023 = spark.read.option("multiline", "true").json(filePath2023)
val df2024 = spark.read.option("multiline", "true").json(filePath2024)

// Afficher un aperçu des données (optionnel)
println("Fichier 2023 :")
df2023.show(5)

println("Fichier 2024 :")
df2024.show(5)

// Ajouter une colonne pour identifier l'année dans chaque DataFrame
val df2023WithYear = df2023.withColumn("year", lit(2023))
val df2024WithYear = df2024.withColumn("year", lit(2024))

// Combiner les DataFrames
val combinedDF = df2023WithYear.union(df2024WithYear)

// Afficher le DataFrame combiné (optionnel)
println("DataFrame combiné :")
combinedDF.show(5)

// Configuration pour MongoDB
val mongoUri = "mongodb+srv://maxyspageau:UIr3651V@cluster0.nrkl0.mongodb.net/cve-database?retryWrites=true&w=majority"
val writeConfig = WriteConfig(
  Map(
    "uri" -> mongoUri,
    "database" -> "cve-database",      // Nom de la base MongoDB
    "collection" -> "cve-files",      // Nom de la collection
    "writeConcern.w" -> "majority"
  )
)

// Sauvegarder les données dans MongoDB
MongoSpark.save(combinedDF.write.format("com.mongodb.spark.sql").options(writeConfig))

println("Les données ont été envoyées à MongoDB Atlas avec succès.")
