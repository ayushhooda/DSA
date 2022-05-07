package dsa.stack

import scala.collection.mutable.Stack

object ValidParanthesis {

  def isValid(s: String): Boolean = {
    var i = 0
    val stack: Stack[Char] = new Stack[Char].empty

    while(i < s.length) {
      val condition1 = stack.nonEmpty && s(i) == ')' && stack.top == '('
      val condition2 = stack.nonEmpty && s(i) == ']' && stack.top == '['
      val condition3 = stack.nonEmpty && s(i) == '}' && stack.top == '{'
      val balanceCondition = condition1 || condition2 || condition3
      if (balanceCondition)
        stack.pop
      else
        stack.push(s(i))
      i = i + 1
    }
    if(stack.nonEmpty)
      false
    else
      true
  }

  def main(args: Array[String]): Unit = {
    print(isValid("()"))
  }

}
