package rdd_basics

import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.api.java.JavaSparkContext

fun main() {
    val inputData = (1..1_000).toList()

    Logger.getLogger("org.apache").level = Level.WARN

    val conf = SparkConf().setAppName("mapping").setMaster("local[*]")
    val sc = JavaSparkContext(conf)

    val myRDD = sc.parallelize(inputData)

    val result = myRDD.map {v: Int ->
        Math.sqrt(v.toDouble())
    }.reduce { v1: Double, v2: Double ->
        v1 + v2
    }

    println(result)

    sc.close()
}