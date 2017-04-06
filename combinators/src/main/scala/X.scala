import scala.util.parsing.combinator._

object Arith extends JavaTokenParsers {
  def expr: Parser[Any] = term~rep("+"~term | "-"~term)
  def term: Parser[Any] = factor~rep("*"~factor | "/"~factor)
  def factor: Parser[Any] = floatingPointNumber | "("~expr~")"
  def xx = "xxx" | "yyy" | failure("hello")



  def fn = (wholeNumber ^^ (_.toInt))

  def trm :Parser[Int] = fn~rt ^^ ((x) => x._1 + x._2)

  def x(l : List[~[String, Int]]) : Int = {
    l match {
      case Nil => 0
      case "+"~v :: tl => v + x(tl)
      case "-"~v :: tl => -v + x(tl)
    }

  }
  def rt : Parser[Int] = rep("+"~fn|"-"~fn) ^^ x _

  //ef e2 : Parser[Double]= fn~rest ^^ ((x : Double~Double) => x._1 + x._2)
  def rest : Parser[Double] = opt("+"~fn~rest) ^^ {case None => 44 ; case Some(x) => x._2}

  def main(args: Array[String]) {

    println(parseAll(expr, "1 + 3 - 5"))
  }
}

