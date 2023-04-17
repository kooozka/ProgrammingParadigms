class Rectangle(var width: Double, var height: Double) extends Figure {
  if width <= 0 || height <= 0 then throw new IllegalArgumentException("Negative input!")

  def this(side: Double) = this(side, side)


  def area: Double = width * height

  def setWidth(newWidth: Double) = {
    if newWidth <= 0 then throw new IllegalArgumentException("Negative input!")
    width = newWidth
  }

  def setHeight(newHeight: Double) = {
    if newHeight <= 0 then throw new IllegalArgumentException("Negative input!")
    height = newHeight
  }

  override def toString: String = "Rectangle; area: " + area
}



