import java.io._
import java.math._
import java.security._
import java.text._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.List
import scala.collection.mutable._
import scala.collection.concurrent._
import scala.concurrent._
import scala.io._
import scala.math._
import scala.sys._
import scala.util.matching._
import scala.reflect._



object Result {

  /*
   * Complete the 'getFinalOrder' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. INTEGER_ARRAY amount
   */

  def getFinalOrder2(k: Int, amount: Array[Int]): Array[Int] = {
    // Write your code here
    val len = amount.length
    var res: List[(Int, Int)] = List[(Int, Int)]()
    for (i <- 0 until len) {
        res = res.:+(amount(i) / k, i + 1)
    }
    res.sortBy(_._1).map(_._2).toArray
  }

  def getFinalOrder(k: Int, amount: Array[Int]): Array[Int] = {
    // Write your code here
    val len = amount.length
    def innerFunc(innerK: Int, innerAmount: Array[Int], res: Array[Int]): Array[Int] = {
      var j = 0
      while (j < len) {
        for(i <- 0 until len) {
          if (innerAmount(i) > 0 && innerAmount(i) <= innerK) {
            res(j) = i + 1
            j = j + 1
            innerAmount(i) = innerAmount(i) - k
          } else {
            innerAmount(i) = innerAmount(i) - k
          }
        }
      }
      res
    }
    innerFunc(k, amount, new Array[Int](len))
  }

}

object Solution {
  def main(args: Array[String]) {
    //val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val k = 2
    val amount = Array(1, 3, 2)
    val result = Result.getFinalOrder2(k, amount)

    println(result.mkString("\n"))

  }
}
