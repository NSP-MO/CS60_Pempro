import scala.io.StdIn.readLine
import scala.io.StdIn.readInt
import scala.collection.mutable.Queue

object Main {
    def main(args: Array[String]): Unit = {
        val firstLine = readLine().split(" ")
        val m = firstLine(0).toInt
        val src = firstLine(1)

        var adj = Map.empty[String, Set[String]].withDefaultValue(Set())
        for (_ <- 1 to m) {
            val Array(u, v) = readLine().split(" ")
            adj += u -> (adj(u) + v)
            adj += v -> (adj(v) + u)
        }

        var adjPulau = Set.empty[String]
        val queue = Queue[String](src)
        while (queue.nonEmpty) {
            val node = queue.dequeue()
            if (!adjPulau.contains(node)) {
                adjPulau += node
                for (nei <- adj(node) if !adjPulau.contains(nei)) {
                    queue.enqueue(nei)
                }
            }
        }
        val pulau = adjPulau.toList.sorted
        pulau.foreach(println)
    }
}