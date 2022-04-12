package dsa.dp

object LongestPalindromeSubstring {

  // checks palindrome by adding start and end char to already checked substring
  def isPalindrome(dp: Array[Array[Int]], i: Int, j: Int, s: String): Boolean = {
    (s(i) == s(j)) && (dp(i + 1)(j - 1) == 1)
  }

  def longestPalindrome(s: String): String = {
    val len = s.length
    val dp: Array[Array[Int]] = Array.ofDim[Int](len, len)
    var maxSubStrLen = 0
    var subStrStartIndex = 0
    var subStrEndIndex = 0

    // filling diagonals as 1, as single character is always palindrome
    // filling 2 length substrings by comparing the first and last/second character
    for (i <- 0 until len) {
      for (j <- 0 until len) {
        if ((i == j) || (i == j - 1 && s(i) == s(j))) {
          dp(i)(j) = 1
          if (j - i > maxSubStrLen) {
            maxSubStrLen = j - i
            subStrStartIndex = i
            subStrEndIndex = j
          }
        }
        if (i == j - 1 && s(i) != s(j)) {
          dp(i)(j) = 0
        }
      }
    }

    var iter = 2
    // fill rest of the cells by using isPalindrome logic
    while(iter < len) {
      val iMax = len - iter
      val jMin = iter
      for ((i, j) <- (0 until iMax).zip(jMin until len)) {
        if (isPalindrome(dp, i, j, s)) {
          dp(i)(j) = 1
          if (j - i > maxSubStrLen) {
            maxSubStrLen = j - i
            subStrStartIndex = i
            subStrEndIndex = j
          }
        } else {
          dp(i)(j) = 0
        }
      }
      iter = iter + 1
    }
    s.substring(subStrStartIndex, subStrEndIndex + 1)
  }

  def main(args: Array[String]): Unit = {
    print(longestPalindrome("a"))
  }
}
