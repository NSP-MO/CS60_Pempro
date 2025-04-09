import scala.io.StdIn.readLine
import scala.math.abs

object Main {

    // alternatif abs tanpa library
    // def abs(x: Int): Int = if (x < 0) -x else x 

    def main(args: Array[String]): Unit = {

        val n = scala.io.StdIn.readInt()

        val a = scala.io.StdIn.readLine().split(" ").map(_.toInt)
        val b = scala.io.StdIn.readLine().split(" ").map(_.toInt)

        val aMax = a.map(abs).max
        val bMax = b.map(abs).max

        val mult = aMax * bMax

        println(mult)
    }
}