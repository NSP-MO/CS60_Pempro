import scala.io.StdIn.readLine

object Main {
    def main(args: Array[String]): Unit = {
        val n = readLine().split(" ").map(_.toLowerCase)
        val a = readLine().split(" ").map(_.toLowerCase)
        val common = n.toSet.intersect(a.toSet)
        println(common.toSeq.sorted.mkString("\n"))
    }
}
