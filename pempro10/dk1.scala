import scala.io.StdIn.readLine

object Main {
    def main(args: Array[String]): Unit = {
        val n = readLine().toInt
        val nums = readLine().split(" ").map(_.toInt)
        val frequencies = nums.groupMapReduce(identity)(_ => 1)(_ + _)
        frequencies.toSeq.sortBy(_._1).foreach { case (num, freq) =>
            println(s"$num -> $freq")
        }
    }
}