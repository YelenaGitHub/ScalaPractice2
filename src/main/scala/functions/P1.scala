package functions

object P1 extends App {

// https://stackoverflow.com/questions/13337338/call-by-name-vs-call-by-value-in-scala-clarification-needed

  // call-by-value
  def f(t: Unit): Unit = {
    println("t")
    println(t) // first
  }

  // call-by-name
  def f1(t: () => Unit): Unit = {
    println("t") // first
    println(t)
  }

  f(println("1"))

  f1(() => println("2"))

}
