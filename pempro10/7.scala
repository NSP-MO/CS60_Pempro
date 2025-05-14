import scala.io.StdIn.readLine

object Main {
    def main(args: Array[String]): Unit = {
        val n = readLine().toInt
        val names = scala.collection.mutable.Set[String]()
        val favorit = scala.collection.mutable.Set[String]()

        for (_ <- 1 to n) {
            val line = readLine()
            val Array(a, _, b) = line.split(" ").map(_.trim)
            names += a
            names += b
            favorit += b
        }

        val notfavorit = names.diff(favorit).toList.sorted
        notfavorit.foreach(println)
    }
}