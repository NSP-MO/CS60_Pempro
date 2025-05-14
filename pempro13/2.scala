import scala.io.StdIn
import scala.collection.mutable

case class Friend(name: String, descriptions: Set[String])

class FriendDir {
  private val friendsByName = mutable.Map.empty[String, Friend]
  private val namesByDesc = mutable.Map.empty[String, mutable.Set[String]]

  def addFriend(nameRaw: String, descRaw: Seq[String]): Unit = {
    val name = nameRaw.trim.split("\\s+").map(_.capitalize).mkString(" ")
    val descs = descRaw.map(_.trim.toLowerCase).toSet
    val friend = Friend(name, descs)
    friendsByName(name) = friend

    for (d <- descs) {
      val setNames = namesByDesc.getOrElseUpdate(d, mutable.Set.empty)
      setNames += name
    }
  }

  def description(descRaw: String): Seq[String] = {
    val key = descRaw.trim.toLowerCase
    namesByDesc.get(key).map(_.toSeq.sorted).getOrElse(Seq.empty)
  }

  def isFriend(nameRaw: String): Boolean = {
    val name = nameRaw.trim.split("\\s+").map(_.capitalize).mkString(" ")
    friendsByName.contains(name)
  }
}

object FriendList {
  def main(args: Array[String]): Unit = {
    val dir = new FriendDir

    val lines = Iterator.continually(StdIn.readLine()).takeWhile(_ != null).map(_.trim).filter(_.nonEmpty)

    for (line <- lines) {
      if (line.toLowerCase.startsWith("deskripsi:")) {
        val desc = line.split(":", 2)(1)
        val matches = dir.description(desc)
        println(s"${desc.trim.capitalize} :")
        matches.foreach(name => println(s"- $name"))

      } else if (line.toLowerCase.startsWith("nama:")) {
        val nameQ = line.split(":", 2)(1)
        if (dir.isFriend(nameQ)) {
          println(s"${nameQ.trim.split("\\s+").map(_.capitalize).mkString(" ")} adalah teman")
        } else {
          println(s"${nameQ.trim.split("\\s+").map(_.capitalize).mkString(" ")} bukan teman")
        }

      } else {
        val Array(namePart, descPart) = line.split(":", 2)
        val descList = descPart.split(",").toSeq
        dir.addFriend(namePart, descList)
      }
    }
  }
}
