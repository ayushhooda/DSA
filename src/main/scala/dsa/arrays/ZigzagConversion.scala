package dsa.arrays

object ZigzagConversion {

  def convert(s: String, numRows: Int): String = {
    val arr = new Array[String](numRows)
    s
  }

  def main(args: Array[String]): Unit = {
    val str = "PAYPALISHIRING"
    val numOfRows = 3
    val res = convert(str, numOfRows)
    print(res)
  }

}
