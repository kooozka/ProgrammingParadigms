import scala.annotation.tailrec

def modifiedPascalIF1(n: Int): List[Int] =
  def modifiedPascalIFInside(i: Int, lst: List[Int], flag: Int): List[Int] =
    lst match
      case List() => List(1)
      case _ :: List() => List(1)
      case h :: t if i % 2 == 0 && flag == 1 => 1 :: h + t.head :: modifiedPascalIFInside(i, t, 0)
      case h :: t if i % 2 == 0 => h + t.head :: modifiedPascalIFInside(i, t, 0)
      case h :: t if flag == 1 => 1 :: h - t.head :: modifiedPascalIFInside(i, t, 0)
      case h :: t => h - t.head :: modifiedPascalIFInside(i, t, 0)
  if n < 0 then List()
  else if n == 0 then modifiedPascalIFInside(0, List(), 0)
  else if n == 1 then List(1,1)
  else modifiedPascalIFInside(n, modifiedPascalIF1(n-1), 1)

modifiedPascalIF1(-1)
modifiedPascalIF1(0)
modifiedPascalIF1(1)
modifiedPascalIF1(2)
modifiedPascalIF1(3)
modifiedPascalIF1(4)
modifiedPascalIF1(5)
modifiedPascalIF1(6)

def modifiedPascalIF2(n: Int): List[Int] = {
  @tailrec
  def modifiedPascalIFInside(i: Int, lst: List[Int], rtrLst: List[Int]): List[Int] = {
    lst match
      case List() => 1 :: rtrLst
      case _ :: List() => (1 :: rtrLst).reverse
      case h :: t if i % 2 == 0 => modifiedPascalIFInside(i, t, h + t.head :: rtrLst)
      case h :: t => modifiedPascalIFInside(i, t, h - t.head :: rtrLst)
  }
  if n < 0 then List()
  else if n == 0 then modifiedPascalIFInside(0, List(), List())
  else modifiedPascalIFInside(n, modifiedPascalIF2(n-1), List(1))
}

modifiedPascalIF2(-1)
modifiedPascalIF2(0)
modifiedPascalIF2(1)
modifiedPascalIF2(2)
modifiedPascalIF2(3)
modifiedPascalIF2(4)
modifiedPascalIF2(5)
modifiedPascalIF2(6)


def modifiedPascalIF3(n: Int) = {
  @tailrec
  def modifiedPascalIFInside(i: Int, list: List[Int], rtrLst: List[Int], counter: Int): List[Int] = {
    list match
      case List() => modifiedPascalIFInside(i + 1, List(1), List(1), counter)
      case _ :: List() if counter > i => modifiedPascalIFInside(i + 1, 1 :: rtrLst, List(1), counter)
      case _ :: List() if i % 2 != 0 => (1 :: rtrLst).reverse
      case _ :: List() => 1 :: rtrLst
      case h :: t if i % 2 == 0 => modifiedPascalIFInside(i, t, h + t.head :: rtrLst, counter)
      case h :: t => modifiedPascalIFInside(i, t, h - t.head :: rtrLst, counter)
  }
  if n < 0 then List()
  else if n == 0 then List(1)
  else modifiedPascalIFInside(0, List(), List(), n)
}



modifiedPascalIF3(-1)
modifiedPascalIF3(0)
modifiedPascalIF3(1)
modifiedPascalIF3(2)
modifiedPascalIF3(3)
modifiedPascalIF3(4)
modifiedPascalIF3(5)
modifiedPascalIF3(6)


def modifiedPascalI(n: Int): Array[Int] =
  if n < 0 then Array()
  else {
    val arr1 = new Array[Int](n + 1)
    val arr2 = new Array[Int](n + 1)
    arr1(0) = 1
    arr2(0) = 1
    var i = 1
    while i < n + 1 do {
      if (i % 2 == 0) {
        var j = 1
        while j < i + 1 do
          arr2(j) = arr1(j - 1) + arr1(j)
          j += 1
      }
      else {
        var k = 1
        while k < i + 1 do
          arr1(k) = arr2(k - 1) - arr2(k)
          k += 1
      }
      i += 1
    }
    if n % 2 == 0 then arr2
    else arr1
  }

modifiedPascalI(-1)
modifiedPascalI(0)
modifiedPascalI(1)
modifiedPascalI(2)
modifiedPascalI(3)
modifiedPascalI(4)
modifiedPascalI(5)
modifiedPascalI(6)