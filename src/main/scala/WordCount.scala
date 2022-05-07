import org.apache.spark.sql.{DataFrame, SparkSession}

object WordCount extends App {


  val sparkSession = SparkSession.builder().appName("WordCount").master("local[*]").getOrCreate()

  val df: DataFrame = sparkSession.read.load("/Users/ayushhooda/IdeaProjects/Learning/src/main/resources/abc.txt")

  df.show(false)


  Exception
//  sparkSession.sql("select word, count() as from mytable groupby ")
  df.map(row => row.getAs[String](0).split(" "))
//
  df.groupBy("_1").count()
}
