package string

import scala.annotation.tailrec

object ValidParentnessNotNested extends App {

  // https://leetcode.com/problems/valid-parentheses/
  //  Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
  //
  //    An input string is valid if:
  //
  //  Open brackets must be closed by the same type of brackets.
  //    Open brackets must be closed in the correct order.
  //    Every close bracket has a corresponding open bracket of the same type.
  //
  //  Example 1:
  //
  //    Input: s = "()"
  //  Output: true
  //  Example 2:
  //
  //    Input: s = "()[]{}"
  //  Output: true
  //  Example 3:
  //
  //    Input: s = "(]"
  //  Output: false

  val parentnessMap = Map('(' -> ')', '[' -> ']', '{' -> '}')

  def isValid(s: String): Boolean = {

    @tailrec
    def helper(s: Seq[Char], isValid: Boolean): Boolean = {
      s match {
        case Nil => isValid
        case _ :: Nil => false
        case x :: xs :: tail => helper(tail, parentnessMap.get(x) == Some(xs))
      }
    }

    helper(s.toList, true)
  }

  val str = "()[]{}"
  val res = isValid(str)

  println(res)

}
