object Factorial {

    def factorial(n: Int): Int = {
        if (n == 0) 1
        else n * factorial(n - 1)
    }

    def main(args: Array[String]): Unit = {
        val n = scala.io.StdIn.readInt()
        val result = factorial(n)
        println(result)
    }
}