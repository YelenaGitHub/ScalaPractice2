package string

import scala.io.StdIn.readLine

/*
input: aaabbbcdddee
output:a3b3c1d3e2
 */

object P4_CryptString extends App {

  val input: String = readLine()

  val res = input.foldRight(List[(Char, Int)]()) { (e, acc) =>
    (e, acc) match {
      case (e, acc) if acc.isEmpty => (e,1) :: acc
      case (e, _ @ (c, i) :: b) if (c == e) => (c, i + 1) :: b
      case (e, a @ (c, _) :: _) if (c != e) => (e, 1) :: a
    }
  }.map { case (c, i) =>
    i match {
      case 1 => s"$c"
      case _ => s"$c$i"
    }
  }.mkString

  println(res)

}
