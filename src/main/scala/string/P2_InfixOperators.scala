package string

object P2_InfixOperators extends App {

  /**
   * Infix operators do NOT work if an object has a method that takes two parameters
   */

  val g: String = "Check out the big brains on Brad!"
  val r1 = g indexOf 'o' // 6
  val r2 = g.indexOf('o', 7) // 25

  println (r1 + " " + r2)

}
