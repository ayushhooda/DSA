package dsa.dp

object GridTraveler {

  // using recursion : Time complexity - O(2^(m+n))
  def gridTraveler(m: Int, n: Int): Int = {
    if (m == 1 && n == 1)
      1
    else if (m == 0 || n == 0)
      0
    else
      gridTraveler(m - 1, n) + gridTraveler(m, n - 1)
  }

  // using memoization : using auxiliary space of Array[m][n]
  def gridTraveler(m: Int, n: Int, countArr: Array[Array[Int]]): Int  = {
    for(i <- 0 until m)
      countArr(i)(0) = 1
    for(j <- 0 until n)
      countArr(0)(j) = 1
    for(i <- 1 until m) {
      for(j <- 1 until n)
        countArr(i)(j) = countArr(i - 1)(j) + countArr(i)(j - 1)
    }
    countArr(m - 1)(n - 1)
  }


  def main(args: Array[String]): Unit  = {
    val countArr = Array(Array(0,0,0), Array(0,0,0))
    print(gridTraveler(2,3, countArr))
  }

}
