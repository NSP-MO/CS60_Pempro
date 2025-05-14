import scala.io.StdIn.readLine
import scala.io.StdIn.readInt
import scala.collection.mutable

object Main {
    def main(args: Array[String]): Unit = {
        val n = readInt()
        val mapping = mutable.Map[String, String]()
        for (_ <- 1 to n) {
            val Array(t1, t2) = readLine().split(" ").map(_.trim)
            mapping(t1) = t2
        }
        val text = readLine().split(" ").map(_.trim)
        val result = text.map(word => mapping.getOrElse(word, word))
        println(result.mkString(" "))
    }
}
