import scala.io.StdIn.readLine

object Main {
    def Uppercase(s: String): String = {
        s.split(" ").map { word =>
            if (word.nonEmpty) word.head.toUpper + word.tail.toLowerCase else ""
        }.mkString(" ")
    }

    def main(args: Array[String]): Unit = {
        val n = readLine().toInt
        val names = (1 to n).map(_ => readLine())
        val sorted = names.map(Uppercase).sortBy(name => name.split(" ").last.toLowerCase)
        sorted.foreach(println)
    }
}