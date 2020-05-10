package sorting

import sorting.P1.mergeLists

object P2 extends App {

  // sorting list using sorting/P1 mergeLists function
  /**
   *
   * List(9, 7, 1, 3, 2, 4, 14)
   * 1. List(List(9))
   * 2. List(List(9), List(7))
   *  2.1. List(List(7, 9)) - mergeList
   * 3. List(List(7, 9), List(1))
   * 4. List(List(7, 9), List(1), List(3))
   *  4.1. List(List(7, 9), List(1, 3)) - mergeList
   *  4.2. List(List(1, 3, 7, 9)) - mergeList
   */

  def sort[T](list: List[T])(implicit ord: Ordering[T]): List[T] = {

    def mergeList(acc: List[List[T]]): List[List[T]] = {
      acc match {
        case x1 :: x2 :: xs if x1.size == x2.size => mergeList(mergeLists(x1, x2) :: xs)
        case _ => acc
      }
    }

    list
      .foldLeft(List.empty[List[T]])((acc, e) => mergeList(List(e) :: acc))
      .foldLeft(List.empty[T])(mergeLists)
  }

  val list: List[Int] = List.fill(10)(List(10, 4, 7, 2, 6, 3, 11)).flatten

  val res = sort(list)
  println(res)

}
