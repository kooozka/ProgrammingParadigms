//Task2
def lMultiple(n: Int) = {
  LazyList.from(2, 2).take(n).force
}
lMultiple(10)

def skipTakeL[A](lLst: LazyList[A]) = {
  def skipTakeLInside[A](lLstInside: LazyList[A], i: Int, counter: Int): LazyList[A] = {
    (lLstInside, i, counter) match {
      case (LazyList(), _, _) => LazyList()
      case (h #:: t, i, cnt) if i == cnt => h #:: skipTakeLInside(t, 1, cnt + 2)
      case (_ #:: t, i, cnt) => skipTakeLInside(t, i + 1, cnt)
    }
  }
  skipTakeLInside(lLst, -1, 0)
}

skipTakeL(LazyList.from(1).take(22)).force
skipTakeL(LazyList(1,2,3,4,5,6)).force
skipTakeL(LazyList.from(1).take(1)).force
skipTakeL(LazyList.from(1).take(2)).force
skipTakeL(LazyList.from(1).take(2000)).force
skipTakeL(LazyList.from(1).take(20000))
skipTakeL(LazyList.from(0))
skipTakeL(LazyList.empty).force
skipTakeL("a" #:: "b" #:: "c" #:: "d" #:: LazyList()).force