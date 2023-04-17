class Splitter (limitArea: Double){
  if limitArea <= 0 then throw new IllegalArgumentException("wrong limit size")
  private var smallFigures = List[Figure]()
  private var largeFigures = List[Figure]()

  def apply(figure: Figure) = {
    if figure.area < limitArea then smallFigures = smallFigures :+ figure
    else largeFigures = largeFigures :+ figure
  }

  def printSmallFigures() = println(smallFigures)
  def printLargeFigures() = println(largeFigures)
}

object Test:
  def main(args: Array[String]): Unit =
    val r1 = new Rectangle(10, 20)
    val r2 = new Rectangle(10, 100)
    val r3 = new Rectangle(10)
    try
      val r4 = new Rectangle(-10, -20)
    catch
      case e : IllegalArgumentException => println("Illegal argument")
    println(r1.area)
    println(r1.width)
    println(r1.height)
    println(r2.area)
    r1.setWidth(1)
    val s = new Splitter(50)
    s(r1)
    s(r2)
    s(r3)
    s.printLargeFigures()
    s.printSmallFigures()

