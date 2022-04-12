package dsa.twopointers

object TripletSum {

  def searchPair(triplets: List[List[Int]], targetSum: Int, arr: Array[Int], i: Int): List[List[Int]] = {
    var startIndex = i
    var endIndex = arr.length - 1
    var updatedTriplets = triplets
    while (startIndex < endIndex) {
      val sum = arr(startIndex) + arr(endIndex)
      if(sum == targetSum) {
        updatedTriplets = updatedTriplets :+ List(-targetSum, arr(startIndex), arr(endIndex))
        startIndex = startIndex + 1
        endIndex = endIndex - 1
        while (startIndex < endIndex && arr(startIndex) == arr(startIndex - 1))
          startIndex = startIndex + 1 // skip same element to avoid duplicate triplets
        while (startIndex < endIndex && arr(endIndex) == arr(endIndex + 1))
          endIndex = endIndex - 1 // skip same element to avoid duplicate triplets
      } else if(targetSum > sum) {
        startIndex = startIndex + 1
      } else {
        endIndex = endIndex - 1
      }
    }
    updatedTriplets
  }

  def findTriplets(arr: Array[Int]): List[List[Int]] = {
    val sortedArr = arr.sorted
    var triplets: List[List[Int]] = List(List())
    for(i <- sortedArr.indices) {
      if(i > 0 && sortedArr(i) == sortedArr(i - 1)) {
      } else {
        triplets = searchPair(triplets, -sortedArr(i), sortedArr, i + 1)
      }
    }
    triplets.filter(_.nonEmpty)
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(-3, 0, 1, 2, -1, 1, -2)
    print(findTriplets(arr))
  }

}
