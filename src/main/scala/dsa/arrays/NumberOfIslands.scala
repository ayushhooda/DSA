package dsa.arrays

object NumberOfIslands {

  def isValid(i: Int, j: Int, m: Int, n: Int, grid: Array[Array[Char]]): Boolean = {
    !(i < 0 || i >= m || j < 0 || j >= n || grid(i)(j) != '1')
  }

  def numberOfIslands(array: Array[Array[Char]]): Int = {
    val row = array.length
    val col = array(0).length
    var count = 0

    for (i <- 0 until row) {
      for (j <- 0 until col) {
        if (array(i)(j) == '1') {
          count += 1
          
        }
      }
    }
    count
  }

  def main(args: Array[String]): Unit = {

    // 1 = land, 0 = water
    // island means

    val grid = Array(
      Array('1', '1', '1', '1', '0'),
      Array('1', '1', '0', '1', '0'),
      Array('1', '1', '0', '0', '0'),
      Array('0', '0', '0', '0', '0')
    )

    val res = numberOfIslands(grid)

    print(res)
  }

}
