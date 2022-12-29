(*Zadanie1*)

type reward = Computer |Money of int |Teddy| Reward of (unit -> reward);;

let k = function() -> Computer;;
let j = (k)();;

let x = Reward(function() -> Computer);;
let z = function() -> Computer;;
let f = (z)();;

let getReward rwrd = 
	match rwrd with
	|	Computer -> Computer
	|	Reward(fnct) -> (fnct)()
	|	Money(amount) -> Money(amount)
	|	Teddy -> Teddy;;
	
	
let y = getReward x;;

let buyTicket table position = 
	let rec buyTicketInside = function
		([], _, _) -> []
	|	(h::t, pos, cnt) when pos = cnt -> getReward(h) :: buyTicketInside(t, pos, (cnt + 1))
	|	(h::t, pos, cnt) -> h :: buyTicketInside(t, pos, (cnt + 1))
	in
	buyTicketInside(table, position, 1);;
	
let table = [Reward(function() -> Computer); Reward(function() -> Computer); Reward(function()->Teddy); Reward(function()->Reward(function() -> Money(1000)))];;
	
buyTicket table 1;;
buyTicket table 4;;