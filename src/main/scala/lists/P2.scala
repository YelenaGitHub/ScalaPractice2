package lists

object P2 extends App {

/*
Create List[List[1], List[1,2], List[1,2,3], ....]
*/

  val list = List(1, 2, 3, 4, 5)

  list.foldLeft(List(List.empty[Int]))((accum, x) => {
    (accum.head :+ x) :: accum
  }).reverse

  //list.zipWithIndex.map(x => list.splitAt(x._2)._1)//.flatten
  list.map(x => List(x))

  val l1 = List.empty ::: List(1)
  val l2 = List(1) ::: List(2)
  val l3 = List(l1, l2)
  l3 :+ list

  list.scanLeft(List.empty[Int])((accum, x) => accum :+ x)

}
