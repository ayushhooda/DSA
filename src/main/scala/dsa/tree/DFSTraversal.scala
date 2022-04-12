package dsa.tree

import scala.annotation.tailrec
import scala.collection.mutable.Stack

object DFSTraversal {

  case class TreeNode(data: Int, left: Option[TreeNode] = None, right: Option[TreeNode] = None)

  @tailrec
  def traverseStack(stack: Stack[TreeNode], output: List[Int]): List[Int] = {
    stack match {
      case Stack() => output
      case Stack(_*) =>
        val top: TreeNode = stack.pop()
        for {
          right <- top.right
          left <- top.left
        } yield {
          stack.push(right)
          stack.push(left)
        }
        traverseStack(stack, output :+ top.data)
    }
  }

  def inorderTraversal(root: TreeNode): List[Int] = {
    val stack: Stack[TreeNode] = Stack()
    stack.push(root)
    traverseStack(stack, List())
  }

  def main(args: Array[String]): Unit = {
    val treeNode: TreeNode = TreeNode(1,
      Option(TreeNode(2, Option(TreeNode(4)), Option(TreeNode(5)))),
      Option(TreeNode(3, Option(TreeNode(6)), Option(TreeNode(7)))))
    inorderTraversal(treeNode).foreach(println)
  }

}
