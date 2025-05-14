import scala.io.StdIn.readLine

object Main {
    def main(args: Array[String]): Unit = {
        val Array(n, m) = readLine().split(" ").map(_.toInt)
        val matrix = Array.ofDim[Int](n, m)
        for (i <- 0 until n) {
            matrix(i) = readLine().split(" ").map(_.toInt)
        }
        for (j <- 0 until m) {
            for (i <- 0 until n) {
                print(matrix(i)(j) + (if (i == n - 1) "\n" else " "))
            }
        }
    }
}