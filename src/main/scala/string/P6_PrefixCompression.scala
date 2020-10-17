package string

import scala.annotation.tailrec
import scala.io.StdIn.readLine

/*
input:
  abcdefpr
  abcpqr

output:  
  abc
  defpr
  pqr
 */
object P6_PrefixCompression extends App {

  val input1: String = readLine()
  val input2: String = readLine()

  val acc: String = input1
    .zip(input2)
    .takeWhile(x => x._1 == x._2)
    .unzip
    ._1
    .mkString

  val diff1 = input1.toSeq.diff(acc)
  val diff2 = input2.toSeq.diff(acc)

  println(s"${acc.size} $acc")
  println(s"${diff1.size} $diff1")
  println(s"${diff2.size} $diff2")

//  @tailrec
//  def parse(s: Seq[(Char, Char)], acc: List[Char]): List[Char] = {
//    s match {
//      case Seq(x, rest @ _*) if ((x._1 == x._2)) =>
//        parse(rest, acc + x._1)
//      case _ => acc
//    }
//  }
//
//  val res = input1.zipAll(input2, "", "") match {
//    case x if x.size == 0 => ("", input1, input2)
//    case x => parse(x.toList, "")
//  }
//
//  println(s"${res._1.size} ${res._1}")
//  println(s"${res._2.size} ${res._2}")
//  println(s"${res._3.size} ${res._3}")

}
