class LowUser (private var sec: String) extends User[Low, Low]{
  override def secret: String = sec

  override def secret(s: String): Unit = sec = s
}
