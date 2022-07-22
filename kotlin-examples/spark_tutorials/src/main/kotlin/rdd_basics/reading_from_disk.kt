package rdd_basics

import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.api.java.JavaSparkContext

fun main() {
    Logger.getLogger("org.apache").level = Level.WARN

    val conf = SparkConf().setAppName("startingReading").setMaster("local[*]")
    val context = JavaSparkContext(conf)

    val data = context.textFile("src/main/resources/subtitles/input.txt")

    data.flatMap{s: String ->
        s.split(" ").toTypedArray().iterator()
    }.filter{ w: String ->
        w.length > 1
    }.foreach {w: String ->
        println(w)
    }

    context.close()
}