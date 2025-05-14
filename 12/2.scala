import scala.io.StdIn.readLine

object main {
    def main(args: Array[String]): Unit = {
        val n = readLine().trim().toInt
        val nameLists = (1 to n).map(_ => readLine().split(",").map(_.trim).toSet).toList

        val m = readLine().toInt
        for (_ <- 1 to m) {
            val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
            val intersection = nameLists(a).intersect(nameLists(b)).toList.sorted
            if (intersection.isEmpty) println("-1")
            else println(intersection.mkString(","))
        }
    }
}
