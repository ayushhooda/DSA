package dsa.tree

object DFSBinaryTreePathSum {

  case class TreeNode(data: Int, left: Option[TreeNode] = None, right: Option[TreeNode] = None)

  def ifPathSumExist(root: Option[TreeNode], sum: Int): Boolean = {
    root match {
      case None => false
      case Some(node) =>
        if(node.data == sum && node.left.isEmpty && node.right.isEmpty)
          true
        else
          ifPathSumExist(node.left, sum - node.data) || ifPathSumExist(node.right, sum - node.data)
    }
  }

  def main(args: Array[String]): Unit = {
    val treeNode: TreeNode = TreeNode(1,
      Option(TreeNode(2, Option(TreeNode(4)), Option(TreeNode(5)))),
      Option(TreeNode(3, Option(TreeNode(6)), Option(TreeNode(7)))))
    print(ifPathSumExist(Option(treeNode), 12))
  }

}
