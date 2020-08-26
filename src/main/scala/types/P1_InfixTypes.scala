package types

object P1_InfixTypes extends App {

  case class Person(name: String)
  class Loves[A, B](val a: A, val b: B)

  def announceCouple(couple: Person Loves Person): String =
  //Notice our type: Person loves Person!
    couple.a.name + " is in love with " + couple.b.name

  val romeo = Person("Romeo")
  val juliet = Person("Juliet")

  announceCouple(new Loves(romeo, juliet))
}

object P1_InfixTypes2 extends App {

  case class Person(name: String) {
    def loves(person: Person) = new Loves(this, person)
  }

  class Loves[A, B](val a: A, val b: B)

  def announceCouple(couple: Person Loves Person): String =
  //Notice our type: Person loves Person!
    couple.a.name + " is in love with " + couple.b.name

  val romeo = Person("Romeo")
  val juliet = Person("Juliet")

  announceCouple(romeo loves juliet)

}
