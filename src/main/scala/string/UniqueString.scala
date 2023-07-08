package string

object UniqueString extends App {

  def isUnique(s: String): Boolean = {

    s.foldLeft(true, Set[Char]()) {
      case ( (false, elements), _) => (false, elements)
      case ( (true, elements), e) =>
        if (elements.contains(e)) (false, elements)
        else (true, elements + e)
    }._1

  }


//  val str = "12345" // true
//  val str = "123455" // false
  val str = "112345" // false
  val res = isUnique(str)
  println(res)

}
