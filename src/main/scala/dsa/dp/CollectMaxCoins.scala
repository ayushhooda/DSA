package dsa.dp

object CollectMaxCoins {

  def coinsCount(arr: Array[Array[Int]]): Int = {
    var ans = 0
    val lookup: Array[Array[Int]] = Array.ofDim(arr.length, arr(0).length)
    def innerFunc(row: Int, col: Int): Int = {
      if (row == arr.length || col == arr(0).length)
        return 0
      else {
        if (lookup(row)(col) == 0)
          lookup(row)(col) = Math.max(arr(row)(col) + innerFunc(row, col + 1), arr(row)(col) + innerFunc(row + 1, col))
        ans = lookup(row)(col)
      }
      ans
    }
    innerFunc(0, 0)
  }

  def main(args: Array[String]): Unit = {
    println(coinsCount(Array(Array(0,3,1,1),Array(2,0,0,4), Array(1,5,3,1))))
    println(coinsCount(Array(Array(0,2,1,9),Array(2,0,0,4), Array(1,5,3,1))))
  }

}
