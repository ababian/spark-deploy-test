import org.slf4j.LoggerFactory
import org.apache.spark.sql.SparkSession

object HelloWorld {
  private val logger = LoggerFactory.getLogger(getClass)

  def main(args: Array[String]) {

    val sparkSession = SparkSession.builder.appName(name = "HelloWorld").getOrCreate()

    val helloWorldInputPath = {
      s"s3a://tn-testing-bucket/armandb/hello-world-in/"
    }

    val input = sparkSession.read.textFile(helloWorldInputPath).cache()
    logger.info("Hello World? " + input)

    sparkSession.stop()
  }
}