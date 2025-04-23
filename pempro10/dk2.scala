import scala.io.StdIn.readLine

object Main {
    def countFactors(n: Int): Int = (1 to n).count(n % _ == 0)

    def main(args: Array[String]): Unit = {
        val n = readLine().toInt
        val nums = readLine().split(" ").map(_.toInt)        nums.sorted.foreach { num =>
            println(s"$num -> ${countFactors(num)}")
        }
    }
}