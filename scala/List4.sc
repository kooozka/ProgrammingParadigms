import scala.annotation.tailrec

sealed trait Snapshot
case class Create(text: String) extends Snapshot
case class Add(substring: String, index: Int) extends Snapshot
case class Delete(index: Int, length: Int) extends Snapshot
case class Move(i: Int, j: Int, length: Int) extends Snapshot


sealed trait SnapshotTree[A]
case class Empty[A]() extends SnapshotTree[A]
case class Node[A](snapshot: Snapshot, nextNode: SnapshotTree[A]) extends SnapshotTree[A]

sealed trait ReturnString
case class Str(text: String) extends ReturnString
case class Error() extends ReturnString

def getString(str: ReturnString) = {
  str match {
    case Str(text) => text
    case Error() => ""
  }
}

def createString(text: String) = Str(text)

def cutString(text: String, index: Int, length: Int) = {
  text.substring(index, index+length)
}

def addSubstring(text: String, index: Int, substring: String) = {
  try{
    Str(cutString(text, 0, index) + substring + cutString(text, index, text.length - index))
  }catch{
    case _: StringIndexOutOfBoundsException => Error()
  }
}

addSubstring("abc", 20, "bcd")

def deleteSubstring (text: String, index: Int, length: Int) = {
  try {
    Str(cutString(text, 0, index) + cutString(text, index + length, text.length - (index + length)))
  } catch {
    case _: StringIndexOutOfBoundsException => Error()
  }
}

def move(text: String, i: Int,j: Int, length: Int) = {
  try {
    addSubstring(getString(deleteSubstring(text, i, length)), j, cutString(text, i, length))
  } catch {
    case _: StringIndexOutOfBoundsException => Error()
  }
}


def operation[A](snapshot: Snapshot, text:String) = {
  snapshot match {
    case Create(firstString) => createString(firstString)
    case Add(substring, index) => addSubstring(text, index, substring)
    case Delete(index, length) => deleteSubstring(text, index, length)
    case Move(i, j, length) => move(text, i, j, length)
  }
}

def review[A](snapshot: Snapshot, snapshotTree: SnapshotTree[A]): ReturnString = {
  @tailrec
  def reviewInside(rtrString: ReturnString, tree: SnapshotTree[A]): ReturnString = {
    rtrString match {
      case Error() => Error()
      case Str(_) => tree match {
        case Empty() => rtrString
        case nd: Node[A] => reviewInside(operation(nd.snapshot, getString(rtrString)), nd.nextNode)
      }
    }
  }
  operation(snapshot, getString(reviewInside(Str(""), snapshotTree)))
}
cutString("chrzaszcz", 3, 4)
cutString("chrzaszcz", 0, 7)
cutString("chrzaszcz", 7, 2)

addSubstring("chrzaszcz", 2, "brzdac")
deleteSubstring("chrzaszcz", 2, 3)
move("chrzaszcz", 1, 3, 2)

def tree = Node(Create("a"),
  Node(Add("b", 1),
    Node(Add("c", 1),
      Node(Add("d", 3),
        Node(Add("e", 4),
          Node(Add("e", 5),
            Node(Add("f", 6),
              Node(Add("g", 7),
                Node(Delete(4, 1),
                  Node(Move(1, 2, 1),
                    Empty()))))))))))
review(Delete(0, 2), tree)
review(Delete(0, -1), tree)
review(Delete(-1, 1), tree)
review(Add("kozka", 0), tree)
review(Add("kozka", 20), tree)
review(Add("kozka", 4), tree)
review(Create("kozka"), tree)
review(Move(0, 3, 2), tree)
review(Move(20, 3, 2), tree)