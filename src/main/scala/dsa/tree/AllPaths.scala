package dsa.tree

object AllPaths {

  case class Node(data: Int, left: Node = null, right: Node = null)

  def m1(arr: Array[Int]): Int = {
    val map: scala.collection.mutable.Map[Int, Int] = scala.collection.mutable.Map.empty
    for (i <- arr.indices) {
      if (!map.contains(arr(i))) {
        map.put(arr(i), 1)
      } else {
        val value = map(arr(i))
        map.put(arr(i), value + 1)
      }
    }
    var count = 0
    map.foreach{(kv) =>
      if (kv._2 > 1)
        count  = count + 1
    }
    count
  }
  /*def getAllPaths(node: Node): List[List[Node]] = {
    if (node == null)
      return Nil

  }*/

  def main(args: Array[String]): Unit = {
    //val tree = Node(1, Node(2), Node(3, Node(4), Node(5)))
//    println(getAllPaths(tree))
    println(m1(Array(1,2,3,1,2,3,4,5)))
  }

}
