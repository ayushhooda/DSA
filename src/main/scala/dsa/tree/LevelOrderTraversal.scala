package dsa.tree

import scala.annotation.tailrec
import scala.collection.mutable.Queue
import scala.collection.mutable.ListBuffer

object LevelOrderTraversal {

  case class TreeNode(data: Int, left: Option[TreeNode] = None, right: Option[TreeNode] = None)

  @tailrec
  def processQueue(queue: Queue[TreeNode], res: ListBuffer[ListBuffer[Int]]): List[List[Int]] = {
    queue match {
      case Queue() => res.map(_.toList).toList
      case q@Queue(_*) =>
        val levelSize = q.size
        val currentLevel: ListBuffer[Int] = ListBuffer[Int]()
        for (i <- 0 until levelSize) {
          val currNode = queue.dequeue
          currentLevel.addOne(currNode.data)
          if (currNode.left.isDefined)
            queue.enqueueAll(currNode.left)
          if (currNode.right.isDefined)
            queue.enqueueAll(currNode.right)
        }
        processQueue(queue, res :+ currentLevel)
    }
  }

  def levelOrderTraversal(root: TreeNode): List[List[Int]] = {
    val queue: Queue[TreeNode] = Queue(root)
    processQueue(queue, ListBuffer())
  }

  def main(args: Array[String]): Unit = {
    val treeNode: TreeNode = TreeNode(1,
      Option(TreeNode(2, Option(TreeNode(4)), Option(TreeNode(5)))),
      Option(TreeNode(3, Option(TreeNode(6)), Option(TreeNode(7)))))
    print(levelOrderTraversal(treeNode))
  }

}
