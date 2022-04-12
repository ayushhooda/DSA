package dsa.mergeintervals

import scala.annotation.tailrec

object MergeOverlappingIntervals {

  case class Interval(start: Int, end: Int)

  @tailrec
  def mergeRecursively(inputList: List[Interval], outputList: List[Option[Interval]], interval: Option[Interval]): List[Interval] = {
    inputList match {
      case ele1 :: ele2 :: tail =>
        if (ele2.start <= ele1.end) {
          interval match {
            case Some(inter) =>
              mergeRecursively(ele2 +: tail, outputList, Some(Interval(inter.start, Math.max(inter.end, ele2.end))))
            case None =>
              mergeRecursively(ele2 +: tail, outputList, Some(Interval(ele1.start, Math.max(ele1.end, ele2.end))))
          }
        } else {
          mergeRecursively(ele2 +: tail, outputList :+ interval, None)
        }
      case ele :: _ => (outputList :+ Some(ele)).flatten
      case Nil => outputList.flatten
    }
  }

  def mergeIntervals(list: List[Interval]): List[Interval] = {
    val sortedList = list.sortBy(_.start)
    val mergedIntervals = List.empty[Option[Interval]]
    mergeRecursively(sortedList, mergedIntervals, None)
  }

  def main(args: Array[String]): Unit = {
    val arr = List(Interval(1,4), Interval(2,5), Interval(3, 6), Interval(7,9))
    print(mergeIntervals(arr))
  }

}
