package rdd_basics

import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.api.java.JavaPairRDD
import org.apache.spark.api.java.JavaSparkContext
import scala.Tuple2

fun main() {
    Logger.getLogger("org.apache").level = Level.WARN

    val conf = SparkConf().setAppName("keywordRanking").setMaster("local[*]")
    val sc = JavaSparkContext(conf)

    val text = sc.textFile("src/main/resources/subtitles/input.txt")

    text.flatMap { raw: String ->
        raw.split(" ").toTypedArray().iterator()
    }.filter { w: String ->
        !w.contains(":")
    }.mapToPair { w: String ->
        Tuple2(w, 1L)
    }.reduceByKey { a: Long, b: Long ->
        a + b
    }.mapToPair { t: Tuple2<String, Long> ->
        Tuple2(t._2, t._1)
    }.sortByKey(false)
        .take(50)
        .toTypedArray()
        .forEach { t: Tuple2<Long, String> ->
        println("(${t._2}, ${t._1})")
    }

    sc.close()
}
