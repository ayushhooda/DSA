package dsa.slidingwindow

/**
 * Longest Subarray with Ones after Replacement
 */
object LongestSubArrayWithOnes {

  def findLength(array: Array[Int], k: Int): Int = {
    var startIndex = 0
    var maxLength = 0
    var count = 0
    for(currentIndex <- array.indices) {
      if(array(currentIndex) == 1)
        count = count + 1

      // current window size is from windowStart to windowEnd, overall we have a maximum of 1s
      // repeating a maximum of 'maxOnesCount' times, this means that we can have a window with
      // 'maxOnesCount' 1s and the remaining are 0s which should replace with 1s.
      // now, if the remaining 0s are more than 'k', it is the time to shrink the window as we
      // are not allowed to replace more than 'k' Os
      if(currentIndex - startIndex + 1 - count > k) {
        if(array(startIndex) == 1)
          count = count - 1
        startIndex = startIndex + 1
      }

      maxLength = Math.max(maxLength, currentIndex - startIndex + 1)
    }
    maxLength
  }

  def main(args: Array[String]): Unit = {
    // arr = [0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2, output=6
    val arr = Array(0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1)
    val k = 2
    println(findLength(arr, k))
  }
}
