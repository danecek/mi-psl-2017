import scala.util.parsing.combinator.JavaTokenParsers

object Main extends JavaTokenParsers {
  def main(args: Array[String]) {

    println(parse(ident ~ ident, "xxx yyy"))
    println(parse("xxx" ~ "yyy", "xxxyyy"))


    println(parseAll(wholeNumber ^^ {
      _.toInt
    }, "3").get + 3)

  }
}
