package string

object UniqueString extends App {

//  def isUnique(s: String): Boolean = {
//    s.foldLeft(true, Set[Char]()) {
//      case ( (_, seen), e) if seen(e) => return false
//      case ( (_, seen), e) => (true, seen + e)
//    }._1
//
//  }

  def isUnique(s: String): Boolean = {
    val seen = scala.collection.mutable.Set[Char]()
    s.takeWhile(c => seen.add(c)).length == s.length
  }

//  val str = "12345" // true
//  val str = "123455" // false
  val str = "112345" // false
  val res = isUnique(str)
  println(res)

}
