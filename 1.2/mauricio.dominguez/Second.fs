module Second

let rec factorial_Recursive x =
    if x = 1 then 1
    else x * (factorial_Recursive x - 1)


let rec factorial_Sequential product counter maxCount =
    if counter > maxCount then product
    else factorial_Sequential (counter * product) (counter + 1) maxCount
    
let factorial x =
    factorial_Sequential 1 1 x

let rec A x y =
    match x, y with
        | x, 0 -> 0
        | 0, y -> 2 * y
        | x, 1 -> 2
        | _ -> A (x - 1) (A x (y - 1))

