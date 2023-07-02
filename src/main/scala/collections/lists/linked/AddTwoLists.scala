package collections.lists.linked

import scala.annotation.tailrec

object AddTwoLists extends App {

  /*
  You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
  You may assume the two numbers do not contain any leading zero, except the number 0 itself.
   */
//
//  Input: l1 = [2,4,3], l2 = [5,6,4]
//  Output: [7,0,8]
//  Explanation: 342 + 465 = 807.

   class ListNode(var x: Int, var next: ListNode = null)

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    addTwoNumbers(l1, l2, 0)
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode, reminder: Int = 0): ListNode = {
    (l1, l2) match {
      case (null, null) => if (reminder > 0) new ListNode(reminder) else null
      case (node1, null) => {
        val sum = node1.x + reminder
        node1.x = sum % 10
        node1.next = addTwoNumbers(node1.next, null, sum / 10)
        node1
      }
      case (null, node2) => {
        val sum = node2.x + reminder
        node2.x = sum % 10
        node2.next = addTwoNumbers(null, node2.next, sum / 10)
        node2
      }
      case (node1, node2) =>
        val sum = node1.x + node2.x + reminder
        node1.x = sum % 10
        node1.next = addTwoNumbers(node1.next, node2.next, sum / 10)
        node1
    }
  }

// not optimized, uses new ListNodes
//  def addTwoNumbers(l1: ListNode, l2: ListNode, carry: Int): ListNode =
//    (l1, l2) match {
//      case (null, null) => if (carry > 0) new ListNode(carry) else null
//      case (node1, null) => {
//        val sum = carry + node1.x
//        new ListNode(sum % 10, addTwoNumbers(node1.next, null, sum / 10))
//      }
//      case (null, node2) => {
//        val sum = carry + node2.x
//        new ListNode(sum % 10, addTwoNumbers(null, node2.next, sum / 10))
//      }
//      case (node1, node2) => {
//        val sum = carry + node1.x + node2.x
//        new ListNode(sum % 10, addTwoNumbers(node1.next, node2.next, sum / 10))
//      }
//    }

//  val l1 = new ListNode(3, new ListNode(4, new ListNode(6)))
//  val l2 = new ListNode(5, new ListNode(1, new ListNode(9)))
// 8551

  val l1 = new ListNode(2, new ListNode(4, new ListNode(3)))
  val l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(3))))

  val res = addTwoNumbers(l1, l2)
  prinlnList(res)

  @tailrec
  def prinlnList(list: ListNode): Unit = {
    list match {
      case (null) =>
      case(e) =>
        println(e.x)
        prinlnList(e.next)
    }
  }

/*
or define foreach for printing custom list
implicit class NodeOps(val node: ListNode) extends AnyVal {
  def foreach(f: Int => Unit): Unit = node match {
    case (n) =>
      f(n.x)
      n.next.foreach(f)
    case None => // do nothing
  }
}

result.foreach(println)
*/

}
