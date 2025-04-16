import scala.io.StdIn.readInt
import scala.io.StdIn.readLine

object Main {
    def filterList(a: Int, operation: (Int) => Boolean): Boolean = {
        operation(a)
    }
    def isEven(a: Int): Boolean = {
        a % 2 == 0
    }
    def isOdd(a: Int): Boolean = {
        a % 2 != 0
    }
    def isPositive(a: Int): Boolean = {
        a > 0
    }
    def isMult(a: Int): Boolean = {
        val sr = math.sqrt(a)
        sr == sr.toInt
    }
    def main(args: Array[String]): Unit = {
        printf("Enter a number: ")
        val n = readInt()
        println("Is the number even: " + filterList(n, isEven))
        println("Is the number odd: " + filterList(n, isOdd))
        println("Is the number positive: " + filterList(n, isPositive))
        println("Is the number a perfect square: " + filterList(n, isMult))
    }
}