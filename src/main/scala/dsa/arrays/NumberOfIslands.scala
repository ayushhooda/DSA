package dsa.arrays

import scala.collection.mutable.Queue

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

  /*def numberOfIslands2(grid: Array[Array[Char]]): Int = {
    val m = grid.length
    val n = grid(0).length
    val bfsQueue: Queue[Char] = new Queue[Char].empty
    var numOfIslands = 0
    val visited: Array[Array[Boolean]] = Array.ofDim(m, n)

    for(i <- 0 until m) {
      for (j <- 0 until n) {
        bfsQueue.empty
        if (grid(i)(j) == '1') {
          numOfIslands = numOfIslands + 1
          visited(i)(j) = true
          bfsQueue.enqueue(grid(i)(j))
          while(bfsQueue.nonEmpty && i < m && j < n) {
            val ele = bfsQueue.dequeue()
            if(ele == grid(i)(j + 1))
              bfsQueue.enqueue(grid(i)(j + 1))
            if(ele == grid(i + 1)(j))
              bfsQueue.enqueue(grid(i)(j + 1))
          }
        }
      }
    }
  }*/

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
