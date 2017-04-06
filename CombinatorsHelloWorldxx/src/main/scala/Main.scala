import scala.util.parsing.combinator.JavaTokenParsers
object Main extends JavaTokenParsers {
  def main(args: Array[String]): Unit = {
    println(parseAll(wholeNumber ^^ {_.toInt }, "3").get + 3)

  }
}
