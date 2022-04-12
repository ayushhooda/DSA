package dsa.arrays

object LongestPalindromeSubstring {

  def ifPalindrome(s: String): Boolean = {
    s.reverse == s
  }

  def longestPalindrome(s: String): String = {
    val strLen = s.length
    if (strLen <= 1) {
      s
    }
    else {
      var temp = ""
      var res = ""
      for (i <- 0 until strLen - 1) {
        temp += s(i)
        for (j <- i+1 until strLen) {
          if(ifPalindrome(temp) && temp.length > res.length) {
            res = temp
          }
          temp += s(j)
        }
        if(temp.length > res.length && ifPalindrome(temp)) {
          res = temp
        }
        temp = ""
      }
      res
    }
  }

  def main(args: Array[String]): Unit = {
      print(longestPalindrome("abccbc"))
  }

}
