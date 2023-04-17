class Terminal[Read <: Low, Write <: Read] (private var keptSecret: String) {
  def read(user: User[_, _ <: Read]): Unit =
    user.secret(keptSecret)

  def write(user: User[_ <: Write, _]): Unit =
    keptSecret = user.secret
}

object Main:
  def main(args: Array[String]): Unit =
    val list:List[Any] = List[Int](1,2,3)
    val list1:List[Any] = List[Double](1,2,3)
    val list2:List[AnyVal] = List[Long](1,2,3)

    val u1 = new LowUser("King Kong")
    val u2 = new HighUser("ABC")
    val u3 = new SuperUser("Pou")
    val u4 = new MixedUser("Sophisticated Gorilla")
    val t1 = new Terminal[High, High]("basicSecret")
    t1.read(u2)
    println(u2.secret)
    t1.write(u3)
    t1.read(u4)
    println(u4.secret)
    t1.read(u1)
    t1.write(u1)