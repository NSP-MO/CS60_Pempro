import scala.io.StdIn.readLine

object Main {
    def main(args: Array[String]): Unit = {
        val n = readLine().toInt
        val names = (1 to n).map(_ => readLine())
        val grouped = names.groupBy(_.length).toSeq.sortBy(_._1)
        for ((len, group) <- grouped) {
            println(s"$len : ${group.mkString(", ")}")
        }
    }
}