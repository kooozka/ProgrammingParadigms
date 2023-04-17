trait User[+Write <: Low, +Read <: Low] {
  def secret: String
  def secret(s: String): Unit
}