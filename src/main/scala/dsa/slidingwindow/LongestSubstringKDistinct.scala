package dsa.slidingwindow

import scala.collection.mutable

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 */
object LongestSubstringKDistinct {

  def findLength(str: String, k: Int): Int = {
    var startIndex = 0
    var maxLength = 0
    val map: mutable.HashMap[Char, Int] = mutable.HashMap[Char, Int]()
    for (i <- 0 until str.length) {
      map.put(str(i), map.getOrElse(str(i), 0) + 1)
      while (map.size > k) {
        map.put(str(startIndex), map.getOrElse(str(startIndex), 0) - 1)
        if(map.getOrElse(str(startIndex), 0) <= 0) {
          map.remove(str(startIndex))
        }
        startIndex = startIndex + 1
      }
      maxLength = Math.max(maxLength, i - startIndex + 1)
    }
    maxLength
  }

  def main(args: Array[String]): Unit = {
    // str = "araaci", k = 2 : Output = 4
    // str = "araaci", k = 1 : Output = 2
    // str = "cbbebi", k = 3 : Output = 5
    print(findLength("cbbebi", 3))

  }

}
