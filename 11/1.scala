import scala.io.StdIn.readLine

object Main {
    def main(args: Array[String]): Unit = {
        val Array(n, m) = readLine().split(" ").map(_.toInt)
        var count = 0
        for (i <- 0 until n) {
            val input = readLine().split(" ").map(_.toInt)
            if (input.distinct.length == input.length) count += 1
        }
        println(count)
    }
}
