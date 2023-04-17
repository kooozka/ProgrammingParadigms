class SuperUser (private var sec: String) extends User[Super, Super]{
  override def secret: String = sec

  override def secret(s: String): Unit = sec = s
}
