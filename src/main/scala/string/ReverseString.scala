package string

object ReverseString extends App {

  def reverse(s: String): String = {

    def helper(left: List[Char], right: List[Char]): List[Char] = {
    right match {
      case Nil => left
      case h :: t => helper(h :: left, t)
    }
    }

    helper(Nil, s.toList).mkString
  }

  println(reverse("Hello, World!"))  // !dlroW ,olleH

}
