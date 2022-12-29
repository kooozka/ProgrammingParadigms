type result = Less | Greater | Equal
module type COMPARATOR = 
sig
	type t
	(*type result = Less | Greater | Equal*)
	val compare: t * t -> result
end;;

module StringComparator: COMPARATOR with type t = string =
	struct
		type t = string
		(*type result = Less | Greater | Equal*)
		let compare(s1, s2) = 
			match (String.compare s1 s2) with
			 |(-1) -> Less
			 |0 -> Equal
			 |1 -> Greater
	end;;
	
StringComparator.compare("a","b");;
StringComparator.compare("b","b");;
StringComparator.compare("c","b");;

module IntComparator: COMPARATOR with type t = int =
	struct
		type t = int
		let compare(i1, i2) = 
			match (i1 < i2) with
			 |true -> Less
			 |false when i1 = i2 -> Equal
			 |false -> Greater
	end;;
	
StringComparator.compare(1,2);;
StringComparator.compare(1,1);;
StringComparator.compare(2,1);;
	
module type PRIORITY_QUEUE =
sig
	type t
	type 'a queue
	exception Empty of string
	val create: unit -> 'a queue
	val insert: 'a queue -> t -> 'a queue
	val retrieve: 'a queue -> t
end;;
	
module PriorityQueueImpl (C: COMPARATOR): PRIORITY_QUEUE with type t = C.t= 
struct
	type t = C.t
	type 'a queue = EmptyQueue | Node of C.t *'a queue *'a queue
	exception Empty of string
	
	let create () = EmptyQueue
	
	let rec insert queue element = 
	match queue with
		|EmptyQueue -> Node(element, EmptyQueue, EmptyQueue)
		|Node(e, left, right) ->
		match C.compare(element, e) with
			|Greater -> Node(element, insert right e, left)
			|Equal -> Node(e, insert right element, left)
			|Less -> Node(e, insert right element, left)
	
	let retrieve x = 
		match x with
		|EmptyQueue -> raise(Empty "Cannot retrieve from empty queue")
		|Node(n, _, _) -> n
end;;

module IntPriorityQueue = PriorityQueueImpl(IntComparator);;
let q = IntPriorityQueue.create();;
IntPriorityQueue.retrieve q;;
let q = IntPriorityQueue.insert q 22;;
let q = IntPriorityQueue.insert q 3;;
let q = IntPriorityQueue.insert q 4;;
let q = IntPriorityQueue.insert q 5;;
let q = IntPriorityQueue.insert q 66;;
let q = IntPriorityQueue.insert q 1;;
IntPriorityQueue.retrieve q;;

IntPriorityQueue.insert(10);;
IntPriorityQueue.insert(0);;
IntPriorityQueue.insert(4);;
IntPriorityQueue.insert(220);;
IntPriorityQueue.insert(29);;
IntPriorityQueue.insert(11);;
IntPriorityQueue.insert(1);;
IntPriorityQueue.retrieve pq;;
	

module PriorityQueueInt=PriorityQueueImpl(IntComparator);;
PriorityQueueInt.insert (PriorityQueueInt.create()) 1;;
PriorityQueueInt.insert (PriorityQueueInt.insert (PriorityQueueInt.create()) 1) 2;;
PriorityQueueInt.insert (PriorityQueueInt.insert (PriorityQueueInt.insert (PriorityQueueInt.create()) 1) 2) 0;;
PriorityQueueInt.retrieve (PriorityQueueInt.insert (PriorityQueueInt.insert (PriorityQueueInt.insert (PriorityQueueInt.create()) 1) 2) 0);;