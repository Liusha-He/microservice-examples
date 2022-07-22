package spark_sql_basics

import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.Row
import org.apache.spark.sql.SparkSession
import java.util.Scanner

fun main() {
    System.setProperty("hadoop.home.dir", "/home/hadoop")
    Logger.getLogger("org.apache").level = Level.WARN

    val sesstion = SparkSession.builder()
        .appName("start")
        .master("local[*]")
        .orCreate

    val dataset: Dataset<Row> = sesstion.read().option("header", true)
        .csv("src/main/resources/exams/students.csv")
    dataset.show()

    val scanner = Scanner(System.`in`)
    scanner.nextLine()

    sesstion.close()
}