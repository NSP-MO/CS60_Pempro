import scala.io.StdIn.readLine
import scala.io.StdIn.readInt

object Main {
    def main(args: Array[String]): Unit = {
        val Array(n, m) = readLine().split(" ").map(_.toInt)
        val input = readLine().split(" ").map(_.toInt)

        val sum = for (i <- 0 until m) yield {
            (i until n by m).map(input(_)).sum
        }
        println(sum.mkString(" "))
    }
}