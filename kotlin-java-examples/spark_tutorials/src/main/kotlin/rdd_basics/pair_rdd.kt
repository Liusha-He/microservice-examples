package rdd_basics

import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.api.java.JavaSparkContext
import scala.Tuple2

fun main(args: Array<String>) {
    val logs = listOf(
        "WARN, Tuesday 4 Sep 0405",
        "INFO, Tuesday 4 Sep 0408",
        "FATAL, Wed 5 Sep 1101",
        "WARN, Wed 5 Sep 1133",
        "ERROR, Wed 5 Sep 1209"
    )

    Logger.getLogger("pairrdd").level = Level.WARN

    val conf = SparkConf()
        .setAppName("startingpairRDD")
        .setMaster("local[*]")
    val sc = JavaSparkContext(conf)

    val logsRDD = sc.parallelize(logs)

    val pairRDD = logsRDD.mapToPair { rawValue: String ->
        val columns = rawValue.split(",").toTypedArray()
        val level = columns[0]
        Tuple2(level, 1L)
    }

    val anotherPairRDD = pairRDD.reduceByKey { a: Long, b: Long ->
        a + b
    }
    anotherPairRDD.foreach { tuple: Tuple2<String, Long> ->
        println(
            tuple._1 + " has " + tuple._2 + " rows"
        )
    }
    sc.close()
}
