
object main {
    def main(args: Array[String]): Unit = {

        val names = List("Andi", "Budi", "Citra", "Ari")
        val grouped = names.groupBy(_.head)
        println(grouped)
        // Output (bisa berbeda urutannya):
        // Map(A -> List(Andi, Ari), B -> List(Budi), C -> List(Citra))
        
    }
}