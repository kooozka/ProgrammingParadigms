trait Figure {
  val area: Double
}

class Rectangle(var width: Double, var height: Double) extends Figure {
  if width <= 0 || height <= 0 then throw new IllegalArgumentException("Negative input!")

  def this(side: Double) = this(side, side)

  val area: Double = width * height

  def setWidth(newWidth: Double) = {
    if newWidth <= 0 then throw new IllegalArgumentException("Negative input!")
    width = newWidth
  }

  def setHeight(newHeight: Double) = {
    if newHeight <= 0 then throw new IllegalArgumentException("Negative input!")
    height = newHeight
  }
}

object Test:
  def main(args: Array[String]): Unit =
    var r1, r2: Rectangle = null
    r1 = new Rectangle(10, 20)
    r2 = new Rectangle(10)
    println(r1.width)
    println(r1.area)
    println(r1.height)
    println(r2.area)

