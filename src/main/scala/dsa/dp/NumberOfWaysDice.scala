package dsa.dp

object NumberOfWaysDice {

  def numOfWays(throws: Int, faces: Int, sum: Int): Int = {
    if (throws == 0 && sum == 0)
      return 1

    if (sum < 0 || faces * throws < sum || throws > sum)
      return 0

    var result = 0
    // recur for all possible solutions
    for (i <- 1 to faces) {
      result += numOfWays(throws - 1, faces, sum - i)
    }

    result
  }

  def numOfWaysDP(throws: Int, faces: Int, sum: Int): Int = {
//
    0
  }

  def main(args: Array[String]): Unit = {
    println(numOfWays(2, 6, 10))
  }

}
