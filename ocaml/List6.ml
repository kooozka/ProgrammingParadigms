(*Zadanie1*)

let modifiedPascalI n = 
	if n < 0 then [||]
	else
	let i = ref 1 and arr1 = Array.make (n+1) 0 and arr2 = Array.make (n+1) 0
		in begin
		arr1.(0) <- 1;
		arr2.(0) <- 1;
		while !i < n+1 do
			if !i mod 2 = 0 then let j = ref 1 in
				while !j < (!i + 1) do arr2.(!j) <- (arr1.(!j-1) + arr1.(!j)); j := !j+1 done;
			else let k = ref 1 in
				while !k < (!i + 1) do arr1.(!k) <- (arr2.(!k-1) - arr2.(!k)); k := !k+1 done;
				;
			i := !i + 1
		done;
	if n mod 2 = 0 then arr2
	else arr1
	end;
;;


modifiedPascalI (-1);;
modifiedPascalI 0;;
modifiedPascalI 1;;
modifiedPascalI 2;;
modifiedPascalI 3;;
modifiedPascalI 4;;
modifiedPascalI 5;;
modifiedPascalI 6;;
	