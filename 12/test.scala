object Main {

    def uniqueWords(words: Vector[String]): Set[String] = {
        words
            .flatMap(_.toLowerCase.replaceAll("[^a-z\\s]", "").split("\\s+"))
            .filter(_.nonEmpty)
            .toSet
    }
    def main(args: Array[String]): Unit = {
        val nums = Vector(1, 2, 3, 4, 5)
        val str = Vector("a b", "b", "c", "d", "e")
        val strq = Vector("Hello, world!", "Hello scala!", "Functional programming in Scala")

        println(uniqueWords(strq))
        println(uniqueWords(strq).mkString(", "))
    }
}
