package string

object CodingViaCounts extends App {

// Преобразование строки вида "AAAABBBCCD" в "4A3B2C1D" 

  def coding(s: String): String = {

    s.foldRight(List.empty[(Char, Int)]) {
      case(char, (headChar, headCount) :: tail) if (char == headChar) => (char, headCount + 1) :: tail
      case (char, acc) => (char, 1) :: acc
    }
      .map { case (char, count) => s"$count$char"}
      .mkString
  }

//    def helper(s: Seq[Char], c: Int, acc: String): String = {
//      (s.toList, c) match {
//        case (Nil, _) => ""
//        case (x :: Nil, c) => acc + (c + 1) + x.toString
//        case (x1 :: x2 :: xs, c) if (x1 == x2) => helper(x2 :: xs, c + 1, acc)
//        case (x1 :: x2 :: xs, c) => helper(x2 :: xs, 0, acc + (c + 1) + x1.toString)
//      }
//    }
//
//    helper(s.toList, 0, "")
//  }

  val s = "AAAABBBCCD"
  val res = coding(s)

  println(res)

  val res2 = s.foldLeft(List.empty[(Char, Int)]) {
    case ((headChar, headCount) :: tail, element) if (headChar == element) => (headChar, headCount + 1) :: tail
    case (accumulated, element) => (element, 1) :: accumulated
  }
    .map { case (k, v) => s"$k$v" }
    .mkString
    .reverse

  println(res2)

}
