        frequencies.toSeq.sortBy(_._1).foreach { case (num, freq) =>
            println(s"$num -> $freq")
        }