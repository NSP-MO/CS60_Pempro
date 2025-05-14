import scala.io.StdIn.readLine

object Main {
    def main(args: Array[String]): Unit = {
        val n = scala.io.StdIn.readInt()
        val a = readLine().split(" ").map(_.toInt)

        val a2 = a.filter(x => {
            val sr = math.sqrt(x)
            sr == sr.toInt
        })
        println(a2.sum)
    }
}