object SimpleCalculator {
  def add(a: Double, b: Double): Double = a + b
  def subtract(a: Double, b: Double): Double = a - b
  def multiply(a: Double, b: Double): Double = a * b
  def divide(a: Double, b: Double): Double = {
    if (b != 0) a / b
    else throw new ArithmeticException("Division by zero")
  }

  def main(args: Array[String]): Unit = {
    println("Enter the first number:")
    println("Enter the second number:")
    println("Choose an operation (add, subtract, multiply, divide):")
    val num1 = scala.io.StdIn.readDouble()
    val num2 = scala.io.StdIn.readDouble()
    val operation = scala.io.StdIn.readLine()
    val result = operation match {
      case "add" => add(num1, num2)
      case "tambah" => add(num1, num2)
      case "subtract" => subtract(num1, num2)
      case "kurang" => subtract(num1, num2)
      case "multiply" => multiply(num1, num2)
      case "kali" => multiply(num1, num2)
      case "divide" => divide(num1, num2)
      case "bagi" => divide(num1, num2)
      case _ => return
    }

    println(s"The result of $operation is: $result")
  }
}