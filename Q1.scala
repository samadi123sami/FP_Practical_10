package prac10_22001816

object Q1 {
  def main(args: Array[String]): Unit = {
    val x = new Rational(-8, 12)
    println(s"x: $x")
    println(s"-x: ${x.neg}")
  }

  class Rational(n: Int, d: Int) {
    require(d != 0, "Denominator must be non-zero")

    private val g = gcd(n.abs, d.abs)
    private val numer: Int = n / g
    private val denom: Int = d / g

    def neg: Rational = new Rational(-numer, denom)

    override def toString: String = s"$numer/$denom"
    
    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  }

}