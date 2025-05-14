import scala.io.StdIn.readLine

object Main {
    def main(args: Array[String]): Unit = {
        val n = readLine().toInt
        val kelas = (1 to n).flatMap { _ =>
            val arr = readLine().split(" ")
            arr.tail
        }.toSet

        val sortedKelas = kelas.toList.sorted

        println(sortedKelas.size)
        sortedKelas.foreach(println)
    }
}
