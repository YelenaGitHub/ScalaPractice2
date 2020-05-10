package sorting

import scala.annotation.tailrec

object P1_MergeSortedLists extends App {

  // merge 2 sorted lists into one with the same sorting order

  def mergeLists[T](l1: List[T], l2: List[T])(implicit ord: Ordering[T]): List[T] = {
    import ord._

    @tailrec
    def accumMerge(l1: List[T], l2: List[T], merged: List[T]): List[T] = {

      (l1, l2) match {
        case (Nil, l2) => merged ::: l2
        case (l1, Nil) => merged ::: l1
        case (x :: xs, y :: _) if x <= y => accumMerge(xs, l2, merged :+ x)
        case (_, y :: ys) => accumMerge(l1, ys, merged :+ y)
      }
    }

    accumMerge(l1, l2, List.empty)

  }

  val l1 = List(1, 4, 7, 9, 10)
  val l2 = List(2, 3, 10, 11, 25)

  val res = mergeLists(l1, l2)
  println(res)

}
