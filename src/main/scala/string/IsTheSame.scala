package string

object IsTheSame extends App {

// Проверка, является ли одна строка перестановкой другой

  def isTheSame(s1: String, s2: String): Boolean = {
    val m1 = symbolsMap(s1)
    val m2 = symbolsMap(s2)
    m1 == m2

    // s1.sorted == s2.sorted // depends on strings size
  }

  private def symbolsMap(s: String): Map[Char, Int] = {
    s.view
      .groupBy(identity)
      .view
      .mapValues(_.size)
      .toMap
  }

  val s1 = "abcdef"
  val s2 = "fedcba"

  val res = isTheSame(s1, s2)
  println(res)

}
