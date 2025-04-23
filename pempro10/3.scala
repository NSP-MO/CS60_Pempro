import scala.io.StdIn.readLine

object Main {
    def main(args: Array[String]): Unit = {
        val n = readLine().toInt
        val words = (1 to n).map(_ => readLine())
        val grouped = words.groupBy(_.last).toSeq.sortBy(-_._2.length)
        for ((lastChar, group) <- grouped) {
            println(s"$lastChar : ${group.length}")
        }
    }
}
