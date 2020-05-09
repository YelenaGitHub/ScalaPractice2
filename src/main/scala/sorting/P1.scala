package sorting

object P1 extends App {

  // merge 2 sorted lists in the sorting order

  def sortList[T](l1: List[T], l2: List[T])(implicit ord: Ordering[T]): List[T] = {

    def accumSort(l1: List[T], l2: List[T], sorted: List[T]): List[T] = {

      (l1, l2) match {
        case (Nil, l2) => sorted ::: l2
        case (l1, Nil) => sorted ::: l1
        case (x :: xs, y :: _) if ord.compare(x, y) <= 0 => accumSort(xs, l2, sorted :+ x)
        case (x :: _, y :: ys) if ord.compare(x, y) > 0 => accumSort(l1, ys, sorted :+ y)
      }
    }

    accumSort(l1, l2, List.empty)

  }

  val l1 = List(1, 4, 7, 9, 10)
  val l2 = List(2, 3, 10, 11, 25)

  val res = sortList(l1, l2)
  println(res)

}
