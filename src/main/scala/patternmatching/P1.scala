package patternmatching

object P1 extends App {

  // using at

  case class B(r: Int, t: Int)
  case class A(a: B)

  A(B(2, 4)) match  {
    case A(a @ B(r, _)) => println(a)
      println(r)
  }

}
