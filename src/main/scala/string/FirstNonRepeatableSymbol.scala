package string

object FirstNonRepeatableSymbol extends App {

//  Нахождение первого не повторяющегося символа
  def findFistUniqueSymbol(s: String): Option[Char] = {

      val counts = s.toSeq.groupBy(identity)
        .view
        .mapValues(_.length)

      s.find(e => counts(e) == 1)
  }

//  val s = "11222234445"
//  val s = "1222234445"
//  val s = "11234445"
  val s = "aabcbbb"
  val res =  findFistUniqueSymbol(s)
  println(res)

}
