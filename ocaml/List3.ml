(*Zadanie1*)
let (>=<) l f =
	let rec helper (lst, f) =
		match lst with
			[] -> []
		|	h :: [] -> []
		|	h :: h1 :: t -> (f h h1) :: helper(t, f)
	in helper(l, f);;

	
let add x y = x + y;;
	
[] >=< (+);;
[1;2] >=< (+);;
[1;1;2] >=< add;;
[1;2] >=< add;;
[1;1;2;2] >=< add;;
[1;1;2;2;3] >=< add;;
[1;1;2;2] >=< add >=< add;;
["a";"b";"c";"d";"e";"f";"g"] >=< (^);;


let rec collapse l f = 
	match l with 
		[] -> []
	|	h :: t when t = [] -> [h]
	|	h :: t -> collapse ((List.hd ([h; List.hd t] >=< f)) :: (List.tl t)) f;;
	
collapse [1;1;2;2;3;3] add;;
collapse [1;1;2;2;3] add;;
collapse [1;2;3;4;5;6;7;8;9] (fun x y -> x*y);;
collapse ["a";"b";"c";"d";"e";"f";"g"] (^);;
collapse[] add;;
collapse[99] add;;

	
(* Zadanie 2 *)
let area (a, b) f n =
    let rec helper iteration =
        if iteration <= n then iteration :: helper (iteration + 1)
        else []
    in let iterationList = (helper 1) 
	and diff = (b -. a) /. float((2 * n))
	
	in let firstSum = (List.fold_left (+.) 0. (List.map (fun x -> f(a +. float(x) *. 2. *. diff)) iterationList))
	and secondSum = (List.fold_left (+.) 0. (List.map (fun x-> f(a +. float(x) *. 2. *. diff -. diff)) iterationList))
	
	in ((b -. a) /. (6. *. float(n))) *. (f(a) -. 3. *. f(b) +. 2. *. firstSum +. 4. *. secondSum);;
	
area (0., 4.) (fun x -> x *. x) 1000;;
area (0., 1.) (fun x-> 1.) 1000;;
area (0., 1.) (fun x -> x *. x) 100;;
area (0., 2.) (fun x -> x *. x *. x *. x) 10000;;
area (2., 0.) (fun x -> x *. x *. x *. x) 10000;;
area (-2., 0.) (fun x -> x *. x *. x *. x) 10000;;
area (0., 4.) (fun x -> x *. x) 10000;;
area (0., 6.) (fun x -> x *. x) 10000 +. area (6., 4.) (fun x -> x *. x) 10000;;
    
	