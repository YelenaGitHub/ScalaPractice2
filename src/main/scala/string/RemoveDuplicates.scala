package string

object RemoveDuplicates extends App {

  def removeDuplicates(str: String): String = {
    str.foldLeft("", Set[Char]()) { case ((result, seen), e) =>
      if (result.contains(e)) (result, seen)
      else (result + e, seen + e)
    }._1
  }

  val str = "Hello, world!"
  println(removeDuplicates(str))  // "Helo, wrd!"

}
