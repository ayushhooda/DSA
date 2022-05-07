package dsa.heap

case class MaxHeap(heap: Array[Int], size: Int, maxSize: Int) {

  /**
   * Fetch parent position
   * @param pos - element position
   * @return - parent position
   */
  def parent(pos: Int): Int = (pos - 1) / 2

  /**
   * Fetch left child position
   * @param pos - element position
   * @return - left child position
   */
  def leftChild(pos: Int): Int = 2 * pos

  /**
   * Fetch right child position
   * @param pos - element position
   * @return - right child position
   */
  def rightChild(pos: Int): Int = (2 * pos) + 1

  /**
   * Identify if the given element is leaf node
   * @param pos - element position
   * @return - Return true if given position is of leaf node
   */
  def isLeaf(pos: Int): Boolean = {
    pos > (size / 2) && pos <= size
  }

  /**
   * Swap two elements in heap
   * @param fpos - first index
   * @param spos - second index
   * @return - MaxHeap with updated swapped heap value
   */
  def swapHeapNodes(fpos: Int, spos: Int): MaxHeap = {
    val temp = this.heap(fpos)
    this.heap(fpos) = this.heap(spos)
    this.heap(spos) = temp
    this
  }

  def maxHeapify(pos: Int): MaxHeap = {
    if (isLeaf(pos))
      this
    else {
      this // todo: not completed
    }
  }


}



object MaxHeapApp {

  def main(args: Array[String]): Unit = {
    // Max Heap Operations
    /**
     * 1. getMax(): It returns the root element of Max Heap. The Time Complexity of this operation is O(1).
     * 2. extractMax(): Removes the maximum element from MaxHeap. The Time Complexity of this Operation is O(Log n)
     *    as this operation needs to maintain the heap property by calling the heapify() method after removing the root.
     * 3. insert(): Inserting a new key takes O(Log n) time. We add a new key at the end of the tree.
     *    If the new key is smaller than its parent, then we don’t need to do anything. Otherwise, we
     *    need to traverse up to fix the violated heap property.
     * 4. maxHeapify(): Helper method for above operations
     */
  }

}
