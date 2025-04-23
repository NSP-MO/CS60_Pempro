import scala.io.StdIn.readLine

object Main {
    def main(args: Array[String]): Unit = {
        val n = readLine().toInt
        val names = (1 to n).map(_ => readLine().split(" : ").map(_.toLowerCase))
        names.foreach { case Array(s1, s2) =>
            if (s1.sorted == s2.sorted) println("Anagram")
            else println("Bukan Anagram")
        }
    }
}
