package collections.lists

object P1_SwappingElements extends App{

  // Swapping elements in String, starting with the first.
  // 1st with 2nd, 3rd with 4th and so on
  /*
  abcdpqrs
  badcqpsr
  */

  import scala.io.StdIn._

  //val l1 = readLine
  //val l2 = readLine

  val l1 = "abcdpqrs"

  def swap(list: Seq[Char]): Seq[Char] = {
    list match {
      case _ :: Nil => Nil
      case x :: xs :: Nil => List(xs, x)
      case x :: y :: rest =>  List(y,x) ++ swap(rest)
    }
  }

  val res = swap(l1.toList).mkString
  if (res != "") println(res)

  l1.toList.sliding(2, 2).flatMap(_.reverse).mkString



}
