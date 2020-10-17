package string

import scala.io.StdIn.readLine

/*
input: ccbabacc
output: cba
 */

object P5_RemoveDuplicates extends App {
  val input: String = readLine()

  val res = input.foldLeft("")((acc, c) => if (acc.contains(c)) acc else acc + c)

  println(res)
}
