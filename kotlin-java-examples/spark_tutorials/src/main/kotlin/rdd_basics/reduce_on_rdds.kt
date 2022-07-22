package rdd_basics

import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.api.java.JavaSparkContext

fun main() {
    val inputData = (1.. 1_000).toList()

    Logger.getLogger("org.apache").level = Level.WARN

    val conf = SparkConf().setAppName("startingSpark").setMaster("local[*]")
    val sc = JavaSparkContext(conf)

    val myRDD = sc.parallelize(inputData)

    val result = myRDD.reduce { v1: Int, v2: Int ->
        v1 + v2
    }

    println(result)

    sc.close()
}