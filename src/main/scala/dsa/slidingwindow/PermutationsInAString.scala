package dsa.slidingwindow

object PermutationsInAString {

  def isPermutationPresent(str: String, pattern: String): Boolean = {
    val patternSum = pattern.foldLeft(0)((x, y) => x + y.toInt)
    val patternSize = pattern.length
    var sum = 0
    var startIndex = 0
    for(i <- str.indices) {
      if(i - startIndex + 1 < patternSize) {
        sum = sum + str(i).toInt
      } else {
        sum = sum + str(i).toInt
        if(sum == patternSum) {
          return true
        } else {
          sum = sum - str(startIndex).toInt
          startIndex = startIndex + 1
        }
      }
    }
    false
  }

  def main(args: Array[String]): Unit = {
    println(isPermutationPresent("oidbcaf", "abc"))
    println(isPermutationPresent("odicf", "dc"))
    println(isPermutationPresent("bcdxabcdy", "bcdyabcdx"))
    println(isPermutationPresent("aaacb", "abc"))
  }

}
