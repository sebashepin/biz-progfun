module Third

let rec fn1_11 n = 
    match n with
        | y when y < 3 -> n
        | y when y >= 3 -> fn1_11 (n - 1) + 2 * fn1_11 (n - 2) + 3 * fn1_11 (n - 3)
    

let rec pascal row col =
    match row, col with
        | row, 1 | col, row -> 1
        | row, col -> pascal (row - 1) (col - 1) + pascal (row - 1) (col)

