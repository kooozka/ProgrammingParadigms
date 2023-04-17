class MixedUser (private var sec: String) extends User[Low, Super]{
  override def secret: String = sec

  override def secret(s: String): Unit = sec = s
}
