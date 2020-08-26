package inheritance

object P1_Sublings extends App {

  trait A {
//    def a: String
    val b: String
//    def c: String = "c"

    println("AAAA")
//    println(a)
    println(b)
//    println(c)
  }

//  trait B extends A {
//    val a: String = "a_1"
//    override val b: String
//    override def c: String = "c_1"
//
//    println("BBBB")
//    println(a)
//    println(b)
//    println(c)
//  }

  class C(/*override val a: String = "a_2", */override val b: String = "b_2"/*, override val c: String = "c_2"*/) extends A {
    println("CCCC")
//    println(a)
    println(b)
//    println(c)
  }

  val c = new C

  /**
   * AAAA
   * a_1
   * b
   * c_1
   *
   * BBBB
   * a_1
   * b_1
   * c_1
   *
   * CCCC
   * a_2
   * b_2
   * c_2
   */



}

/*

-- The second version:
trait A {
val a: String
def b: String
lazy val c: String = {
println("asdsadasdasdaasd")
"c"
}

println(a)
println(b)
println(c)
}

class B extends A{
override val a: String = "_"
override def b: String = "bb"
override lazy val c: String = {
println("asdasd")
"c_1"
}


println(a)
println(b)
println(c)
}


val b = new B
 */