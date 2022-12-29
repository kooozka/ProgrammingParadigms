type snapshot = Create of string| Add of string * int| Delete of int * int| Move of int * int * int;;
type 'snapshot snapshotsTree = Empty | Node of 'snapshot * 'snapshot snapshotsTree;;
type returnString = String of string| Error;;

let tree = Node(Create("a"),
									Node(Add("b", 1),
											Node(Add("c", 1),
													Node(Add("d", 3),
															Node(Add("e", 4),
																Node(Add("e", 5),
																	Node(Add("f", 6),
																		Node(Add("g", 7),
																			Node(Delete(4, 1),
																				Node(Move(1, 2, 1),
																						Empty))))))))));;
																					


	
let createString text = String(text);;

let toString returnString =
    match returnString with
            String(text) -> text
		|	Error -> "";;
	
let cutString text index length = 
	(*try String(String.sub text index length) with Invalid_argument "String.sub / Bytes.sub" -> Error;;*)
	String.sub text index length;;
	
let addSubstring text index substring = 
	try String(cutString text 0 index ^ substring ^ cutString text index (String.length text - index)) with Invalid_argument "String.sub / Bytes.sub" -> Error;;
	
addSubstring "kozka" (-1) "maslo";;
addSubstring "kozka" 1 "maslo";;
	
	
let deleteSubstring text index length =
	try String(cutString text 0 index ^ cutString text (index + length) (String.length text - (index + length))) with Invalid_argument "String.sub / Bytes.sub" -> Error;;
	
deleteSubstring "kozka" (-1) 20;;
deleteSubstring "kozka" 1 20;;
deleteSubstring "kozka" 1 2;;


let move text i j length= 
	(*let textToBeMoved = cutString text i length
	in*)
	try addSubstring (toString(deleteSubstring text i length)) j (cutString text i length) with Invalid_argument "String.sub / Bytes.sub" -> Error;;
	
move "kozka" (-1) 1 3;;
move "kozka" 1 10 3;;
move "kozka" 1 3 2;;

let operation snapshot text = 
	match snapshot with
		Create(firstString) -> createString firstString
	|	Add(substring, index) -> addSubstring text index substring
	|	Delete(index, length) -> deleteSubstring text index length
	|	Move(i, j, length) -> move text i j length;;
	
(*let review snapshot snapshotTree=
	let rec reviewInside = function
			(Error, _) -> Error
		|	(text, Empty) -> text
		|	(text, Node(snapshot, tree)) -> reviewInside(operation snapshot (toString text), tree)
		in
	operation snapshot (toString(reviewInside(String(""), snapshotTree)));;*)
	
let review snapshot snapshotTree=
	let rec reviewInside rtrString tree= 
		match rtrString with
		|	Error -> Error
		|	String(str) -> match tree with
			|	Empty -> rtrString
			|	Node(snap, child) -> reviewInside (operation snap (toString rtrString)) child
		in
	operation snapshot (toString(reviewInside (String("")) snapshotTree));;
	
review (Add("kozka", 1)) tree;;
review (Add("kozka", 1)) tree;;
review (Add("kozka", -2)) tree;;
review (Create("kozka")) tree;;
review (Move(0,3,2)) tree;;
review (Move(20,3,2)) tree;;
review (Delete(-1,2)) tree;;
review (Delete(1,3)) tree;;



		
	


	


