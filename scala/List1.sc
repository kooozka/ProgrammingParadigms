//Task1
def flip5[A, B, C, D, E](x:(A, B, C, D, E))
= (x._4, x._5, x._3, x._2, x._1)

flip5(("A", "B", "C", "D", "E"))
flip5((1, 2.0, 3, 4, "Ala"))
flip5((0, "Jakub", 3.65, "kupa", 11))

//Task2
def roots(a:Double, b:Double, c:Double) = {
  val delta = b * b - 4 * a * c
  if delta > 0 then 2
  else if delta == 0 then 1
  else 0
}

roots(5, 10, 1) //80
roots(4, 5, 3) //-23
roots(2, 4, 2) //0

//Task3
def substitute[A](list:List[A], toBeChanged:A, replacement:A) : List[A] = {
  if list == Nil then Nil
  else if list.head == toBeChanged then replacement :: substitute(list.tail, toBeChanged, replacement)
  else list.head :: substitute(list.tail, toBeChanged, replacement)
}

substitute(List(1,2,1,2,1,2), 1, 3)
substitute(List(), 1, 2)
substitute(List("Ala", "Jan", "Hermenegilda"), "Lucjusz", "Ludwig")

//Task4
def swap2[A](list:List[A]) : List[A] = {
  if list == Nil then Nil
  else if list.tail == Nil then list.head :: Nil
  else list.tail.head :: list.head :: swap2(list.tail.tail)
}

swap2(List())
swap2(List(1,2,3))
swap2(List(1,2,3,4,5,6))