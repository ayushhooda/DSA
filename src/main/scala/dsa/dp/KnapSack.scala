package dsa.dp

object KnapSack {

  // Approach : 1
  def knapSackRecursive(profit: Array[Int], weight: Array[Int], capacity: Int): Int = {
    def innerFunc(profit: Array[Int], weight: Array[Int], capacity: Int, currentIndex: Int): Int = {
      // base checks
      if (capacity <= 0 || currentIndex >= profit.length)
        0

      // base profit
//      var profit1 = 0
      if(weight(currentIndex) <= capacity) {
        val profit1 = profit(currentIndex) + kn
      }
    }
    innerFunc(profit, weight, capacity, 0)
  }

  def main(args: Array[String]): Unit = {
    val profits = Array(4, 5, 3, 7)
    val weights = Array(2, 3 ,1, 4)
    val capacity = 5
    print(knapSackRecursive(profits, weights, capacity))
  }

}
