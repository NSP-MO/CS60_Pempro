import scala.io.StdIn.readLine

def nilaiMutu(nilai: String): Double = nilai match {
    case "A"  => 4.0
    case "AB" => 3.5
    case "B"  => 3.0
    case "BC" => 2.5
    case "C"  => 2.0
    case "D"  => 1.0
    case "E"  => 0.0
    case  _   => 0.0
}
    
object Main {
    def main(args: Array[String]): Unit = {
        val n = readLine().toInt

        val data = scala.collection.mutable.Map[String, (String, List[Double])]()

        for (_ <- 0 until n) {
            val input = readLine().split(", ").map(_.trim)
            val nim = input(0)
            val nama = input(1)
            val nilai = nilaiMutu(input(3))

            if (data.contains(nim)) {
                val (listNama, listNilai) = data(nim)

                if (listNama != nama) {
                    data(nim) = (listNama, nilai :: listNilai)
                }
                else {
                    data(nim) = (nama, nilai :: listNilai)
                }
            } else {
                data(nim) = (nama, List(nilai))
            }
        }

        data.values.foreach { case (nama, nilaiList) =>
            val ipk = nilaiList.sum / nilaiList.size
            println(f"$nama $ipk%.2f")
        }
        
    }
}