package dsa.linkedlists


class ListNode(_x: Int = 0, _next: ListNode = null) {
   var next: ListNode = _next
   var x: Int = _x
}


object AddTwoNumbers {

  def addNodeData(ptr1: ListNode, ptr2: ListNode, carry: Int): (Int, Int) = {
    if(ptr1 == null) {
      getResAndCarry(ptr2.x + carry)
    } else if (ptr2 == null) {
      getResAndCarry(ptr1.x + carry)
    } else {
      getResAndCarry(ptr1.x + ptr2.x + carry)
    }
  }

  // return (data, carry)
  def getResAndCarry(res: Int): (Int, Int) = {
    if (res > 9)
      (res % 10, res / 10)
    else
      (res, 0)
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var ptr1 = l1
    var ptr2 = l2
    var carry = 0
    var head: ListNode = null
    var last: ListNode = null
    while(ptr1 != null || ptr2 != null) {
      val (res, c) = addNodeData(ptr1, ptr2, carry)
      // add this res to new list
      val node = new ListNode(res, null)
      if (head == null) {
        head = node
        last = node
      } else {
        last.next = node
        last = node
      }
      // update carry
      carry = c
      if(ptr1 != null) {
        ptr1 = ptr1.next
      }
      if(ptr2 != null) {
        ptr2 = ptr2.next
      }
    }
    if(carry != 0) {
      val node = new ListNode(carry, null)
      last.next = node
      last = node
    }
    head
  }

  def main(args: Array[String]): Unit = {
    val l1 = new ListNode(5, null)
    val l2 = new ListNode(4, null)
    val x = addTwoNumbers(l1, l2)
    val r = 5
    print("hello")
  }

}
