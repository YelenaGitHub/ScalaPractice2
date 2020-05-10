package string

object P1_MergeStrings extends App {

  // Merge 2 strings, by the same elements indicies.

  def f(args: Array[String]): Unit = {
    val res = for {
      a1 <- args(0)
      a2 <- args(1)
    } yield a1 + a2
    println(res)
  }

  val arr = Array("hacker", "ranker")
  val s1 = arr(0)
  val s2 = arr(1)

  s1.zip(s2)
  s1.zip(s2).mkString
  s1.zip(s2).map(x => x._1.toString + x._2.toString).mkString

  s1.zip(s2).flatMap(x => Vector(x._1, x._2)).mkString

  /*
  hacker
  ranker

  hraacnkkeerr
  */



}
