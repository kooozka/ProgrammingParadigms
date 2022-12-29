(*Task1*)
let find lst x = 
	let rec findInside (inLst, x, rtrLst, ctr) = 
		match (inLst, x) with
			([], _) -> rtrLst
		|	(head :: tail, x) when head = x -> findInside(tail, x, ctr :: rtrLst, ctr + 1)
		|	(_ :: tail, x) -> findInside(tail, x, rtrLst, ctr + 1)
		in
	findInside(lst, x, [], 0);;
	
find [] 1;;
find [1;1;1;2;1] 1;;
find [2;2;4;5] 1;;
find ["ala"; "ma"; "kota"; "ala"] "ala";;

let find123 = find [1;2;3];;
find123 3;;
find123 4;;

(*Task2*)
let rec split2Rec lst = 
	match lst with
		[]					-> ([], [])
	|	(head :: tail)  -> let (sublist1, sublist2) = split2Rec tail in (head :: sublist2, sublist1);;
		
split2Rec [];;
split2Rec [1];;
split2Rec [1;2;3];;
split2Rec [1;2;3;4];;
split2Rec ["a"; "b"; "c"; "d"];;

let split2Tail lst = 
	let rec split2TailInside (inLst, pair) = 
		match inLst with
			[] -> pair
		|	(head :: tail) -> split2TailInside(tail, (head :: snd pair, fst pair))
	in
	split2TailInside(lst, ([],[]));;
	
split2Tail [];;
split2Tail [1];;
split2Tail [1;2;3];;
split2Tail [1;2;3;4];;
split2Tail ["a"; "b"; "c"; "d"];;
		
