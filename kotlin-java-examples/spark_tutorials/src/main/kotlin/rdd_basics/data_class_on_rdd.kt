package rdd_basics

import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.api.java.JavaSparkContext

data class IntegerWithSqrt(val orig: Int, val s: Double)

fun main() {
    val inputData = (1..1_000).toList()

    Logger.getLogger("org.apache").level = Level.WARN

    val conf = SparkConf().setAppName("mapping").setMaster("local[*]")
    val sc = JavaSparkContext(conf)

    val original = sc.parallelize(inputData)
    val sqrtInts = original.map { v: Int ->
        IntegerWithSqrt(v, Math.sqrt(v.toDouble()))
    }

    sqrtInts.foreach {
        v: IntegerWithSqrt -> println("${v.orig} -> ${v.s}")
    }

    sc.close()
}
