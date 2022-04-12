package dsa.arrays

object RottenOranges {

  def isUpperSafe(i: Int, bound: Int): Boolean = {
    i + 1 < bound
  }

  def isLowerSafe(i: Int): Boolean = {
    i - 1 >= 0
  }

  def orangesRotting(grid: Array[Array[Int]]): Int = {

    var numOfMinutes = 0
    var flag = 0
    var decision = 0
    var loop = true
    var x = 0

    // number of columns
    val n: Int = grid(0).length
    // number of rows
    val m: Int = grid.length

    while (loop) {
      x = 0
      flag = 0
      for (i <- 0 until m) {
        for (j <- 0 until n) {

          if (grid(i)(j) == 2) {
            if (isUpperSafe(i, m) && grid(i+1)(j) == 1) {
              grid(i+1)(j) = -1
              flag = 1
              x = 1
            }
            if (isUpperSafe(j, n) && grid(i)(j+1) == 1) {
              grid(i)(j+1) = -1
              flag = 1
              x = 1
            }
            if (isLowerSafe(i) && grid(i-1)(j) == 1) {
              grid(i-1)(j) = -1
              flag = 1
              x = 1
            }
            if (isLowerSafe(j) && grid(i)(j-1) == 1) {
              grid(i)(j-1) = -1
              flag = 1
              x = 1
            }
          }

        }
      }
      for (i <- 0 until m) {
        for (j <- 0 until n) {
          if (grid(i)(j) == -1) {
            grid(i)(j) = 2
          }
        }}
      if (flag == 1) {
        numOfMinutes = numOfMinutes + 1
      }
      if(x == 0)
        loop = false
    }


    for (i <- 0 until m) {
      for (j <- 0 until n) {
        if (grid(i)(j) == 1) {
          decision = 1
        }
      }
    }

    if (decision == 1){
      -1
    }
    else {
      numOfMinutes
    }
  }

  def main(args: Array[String]): Unit  = {
    val arr: Array[Array[Int]] = Array(Array(2,0,1,1,1,1,1,1,1,1), Array(1,0,1,0,0,0,0,0,0,1), Array(1,0,1,0,1,1,1,1,0,1), Array(1,0,1,0,1,0,0,1,0,1),
      Array(1,0,1,0,1,0,0,1,0,1), Array(1,0,1,0,1,1,0,1,0,1), Array(1,0,1,0,0,0,0,1,0,1), Array(1,0,1,1,1,1,1,1,0,1),
      Array(1,0,0,0,0,0,0,0,0,1), Array(1,1,1,1,1,1,1,1,1,1))

    val arr2 = Array(Array(2,1,1),Array(1,1,1),Array(0,1,2))

    val res = orangesRotting(arr)

    print(res)

  }

}
