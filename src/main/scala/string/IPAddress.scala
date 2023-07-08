package string

object IPAddress extends App {
  
  def isValidIPAddress(s: String): Boolean = {
    val octets = s.split('.')
    octets.length == 4 && octets.forall { octet =>
      octet.length > 0 &&
      octet.forall(_.isDigit) &&
      octet.toInt > 0 &&
      octet.toInt <= 255
    }

  }

  val str = "123.123.090.155" // true
//  val str = "123.123.090.255" // true
//  val str = "123.123.90.256" // false
  val res = isValidIPAddress(str)
  println(res)

}

