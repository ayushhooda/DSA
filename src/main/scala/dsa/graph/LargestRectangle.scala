package dsa.graph
import scala.collection.mutable

object LargestRectangle {

  def isSafe(i: Int, j: Int, m: Int, n: Int): Boolean = {
    i < m && j < n
  }
  def largestRectangle(arr: Array[Array[Int]]): Int = {
    val visited: Array[Array[Boolean]] = Array.ofDim(arr.length, arr(0).length)
    val bfs: mutable.Queue[(Int, Int)] = new mutable.Queue[(Int, Int)].empty
    var count = 0
    var ans = 0
    var ii = 0
    var jj = 0
    for(i <- arr.indices) {
      for (j <- arr(0).indices) {
        if(!visited(i)(j)) {
          visited(i)(j) = true
          if (arr(i)(j) == 1) {
            ii = i
            jj = j
            bfs.enqueue((i, j))
            count = count + 1
          }
          while (isSafe(ii, jj, arr.length, arr(0).length) && bfs.nonEmpty) {
            val (iii, jjj) = bfs.dequeue()
            ii = iii
            jj = jjj
            if (isSafe(ii, jj + 1, arr.length, arr(0).length) && !visited(ii)(jj + 1) && arr(ii)(jj + 1) == 1) {
              bfs.enqueue((ii, jj + 1))
              visited(ii)(jj + 1) = true
              count = count + 1
            }
            if (isSafe(ii + 1, jj, arr.length, arr(0).length) && !visited(ii + 1)(jj) && arr(ii + 1)(jj) == 1) {
              bfs.enqueue((ii + 1, jj))
              visited(ii + 1)(jj) = true
              count = count + 1
            }
            visited(ii)(jj) = true
          }
          bfs.empty
        }
        ans = Math.max(ans, count)
        count = 0
      }
    }
    ans
  }

  // Largest rectangle containing only 1's
  def main(args: Array[String]): Unit = {
    val arr = Array(
      Array(1,0,0,0),
      Array(1,0,1,1),
      Array(1,0,1,1),
      Array(0,1,0,0)
    )
    print(largestRectangle(arr))
  }

}
