package string

object WordsInString extends App {

  def countWordsInString(s: String): Int = {
//    s.split(Array(' ', '\n', '\t')).size
    s.split("\\s+").size
  }

  val s = "A BC\nDEF"
  val res = countWordsInString(s)
  print(res)

}
