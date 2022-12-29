import scala.annotation.tailrec

//Task1
def find[A](lst: List[A])(x: A) = {
  @tailrec
  def findInside[A](inLst: List[A], x: A, rtrLst: List[Int], cnt: Int): List[Int] = {
    (inLst, x) match {
      case (Nil, _) => rtrLst
      case (head :: tail, x) if head == x => findInside(tail, x, cnt :: rtrLst, cnt + 1)
      case (_ :: tail, x) => findInside(tail, x, rtrLst, cnt + 1)
    }
  }

  findInside(lst, x, List(), 0)
}

find(List())(1)
find(List(1, 1, 2, 1))(1)
find(List(2, 2, 2, 3))(1)
find(List("ala", "kot", "samochod", "ala", "ala"))("ala")

val find123 = find(List(1, 2, 3))
find123(1)
find123(4)
find123(2)

//Task2
def split2Tail[A](lst: List[A]) = {
  @tailrec
  def split2TailInside(inLst: List[A], pair: (List[A], List[A])): (List[A], List[A]) = {
    inLst match {
      case Nil => pair
      case head :: tail => split2TailInside(tail, (head :: pair._2, pair._1))
    }
  }
  split2TailInside(lst, (List(), List()))
}

split2Tail(List())
split2Tail(List(1, 2, 3, 4))
split2Tail(List(1))
split2Tail(List(1, 2, 3, 4, 5))
split2Tail(List("Hermengilda", "January"))


def split2Rec[A](lst: List[A]): (List[A], List[A]) = {
  lst match {
    case Nil => (List(), List())
    case head :: tail =>
      val (sublist1, sublist2) = split2Rec(tail)
      (head :: sublist2, sublist1)
  }
}

split2Rec(List())
split2Rec(List(1, 2, 3, 4))
split2Rec(List(1))
split2Rec(List(1, 2, 3, 4, 5))
split2Rec(List("Hermengilda", "January"))

