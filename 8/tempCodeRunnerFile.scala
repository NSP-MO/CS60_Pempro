val n = scala.io.StdIn.readInt()

val a = scala.io.StdIn.readLine().split(" ").map(_.toInt)
val b = scala.io.StdIn.readLine().split(" ").map(_.toInt)

val aMax = a.map(abs).max
val bMax = b.map(abs).max

val mult = aMax * bMax