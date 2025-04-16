import scala.io.StdIn.readInt
import scala.io.StdIn.readLine

object Main {
    def main(args: Array[String]): Unit = {
        val n = readInt()
        val a = readLine().split(" ").map(_.toInt)

        val score = a.filter(x => x >= 0 && x <= 100)

        val mean = score.sum / score.length.toDouble

        val variant = (for(x <- score) yield {
            val diff = x - mean
            diff * diff
        }).sum / score.length.toDouble

        println(f"$variant%.2f")
    }
}