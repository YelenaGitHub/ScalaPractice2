package traits

object P1 extends App {

  trait NamedConst {
    def name: String = this.getClass.getSimpleName.replace("$", "")

    override def toString: String = name
  }

  object stringValue extends NamedConst
  object integerValue extends NamedConst


  println(stringValue.name)

}
