import scala.io.StdIn.readLine
import scala.collection.mutable

class operasi(val name: String, private var balance: Int = 0) {
  def simpan(amount: Int): Unit = balance += amount
  def pinjam(amount: Int): Unit = balance -= amount
  def cekSaldo(): Int           = balance
}

class user {
  private val accounts = mutable.Map.empty[String, operasi]

  private def getOrCreate(name: String): operasi =
    accounts.getOrElseUpdate(name, new operasi(name))

  def simpan(name: String, amount: Int): Unit =
    getOrCreate(name).simpan(amount)

  def pinjam(name: String, amount: Int): Unit =
    getOrCreate(name).pinjam(amount)

  def cekSaldo(name: String): Int =
    getOrCreate(name).cekSaldo()
}

object Main extends App {
  val manager = new user
  val q       = readLine().toInt

  for (_ <- 1 to q) {
    val parts = readLine().split(" ", 3)
    parts(0) match {
      case "Simpan"   => manager.simpan(parts(1), parts(2).toInt)
      case "Pinjam"   => manager.pinjam(parts(1), parts(2).toInt)
      case "CekSaldo" => println(manager.cekSaldo(parts(1)))
      case other      => Console.err.println(s"Typo: $other")
    }
  }
}
