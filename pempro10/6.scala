import scala.io.StdIn.readLine

object Main {
    def main(args: Array[String]): Unit = {
        val text = readLine().replace("(", "").replace(")", "").split(" ").flatMap(_.toLowerCase.split("-"))
        val count = text.groupBy(identity).view.mapValues(_.length).toMap
        println(s"Jumlah total kata: ${text.length}")
        val meanLength = text.map(_.length).sum.toDouble / text.length
        println(f"Mean length: $meanLength%.2f")
        val longest = count.keys.maxBy(_.length)
        println(s"Kata paling panjang: $longest")
        val mostFrequent = count.maxBy(_._2)
        println(s"Kata paling sering: ${mostFrequent._1}")
    }
}

