class HighUser (private var sec: String) extends User[High, High]{
  override def secret: String = sec

  override def secret(s: String): Unit = sec = s
}
