package rdd_basics

import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.api.java.JavaSparkContext

fun main() {
    val logs = listOf(
        "WARN, Tuesday 4 Sep 0405",
        "INFO, Tuesday 4 Sep 0408",
        "FATAL, Wed 5 Sep 1101",
        "WARN, Wed 5 Sep 1133",
        "ERROR, Wed 5 Sep 1209"
    )

    Logger.getLogger("pairrdd").level = Level.WARN

    val context = JavaSparkContext(
        SparkConf().setAppName("startingflatmap").setMaster("local[*]")
    )

    val data = context.parallelize(logs)

    val words = data.flatMap {value: String ->
        value.split(" ").toTypedArray().iterator()
    }.filter { w: String ->
        w.length > 1
    }

    words.foreach { s: String -> println(s) }

    context.close()
}