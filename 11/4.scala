import scala.io.StdIn.readLine

object Main {
    def main(args: Array[String]): Unit = {
        val n = readLine().split(" ").map(_.toInt)
        val count = Array.fill(8)(0)

        for (i <- n if i != -1) {
            if (i >= 1 && i <= 8) {
                count(i - 1) += 1
            }
        }
        println(count.mkString(", "))
    }
}
