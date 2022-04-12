package dsa.arrays

import scala.collection.immutable.HashSet

object LongestSubstring {
  // without repeating characters

  def lengthOfLongestSubstring(s: String): Int = {
    var temp = ""
    var len = 0
    for (i <- s) {
      if (temp.contains(i)) {
        temp = temp.substring(temp.indexOf(i) + 1)
      }
      temp += i
      if(temp.length > len)
        len = temp.length
    }
    len
  }

  def main(args: Array[String]): Unit = {
    val str = "pwwkew"
    print(lengthOfLongestSubstring(str))
  }

}

