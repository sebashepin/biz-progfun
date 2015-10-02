namespace DefaultProgram

module First =

    let Point1_3_sum_squares x y z =
        let square (x:float) = x*x
        // 1.3
        let squareSum x y = square x + square y
        let larger x y = if x > y then x else y
        let squareSumGreater x y z = 
            if x > y then
                squareSum x (larger y z)
            else
                squareSum y (larger x z)
        squareSumGreater x y z
    
    let Point1_6_sqrt x y =
        let square x :float =
            x*x
        let avg a b :float =
            (a + b)/2.0
        let abs x :float = 
            if x < 0.0 then -x
            else x
        let improve guess x = 
            avg guess (x / guess)
        let goodEnough guess x =
            abs((square guess) - x) < 0.001
        let rec sqrt_first guess x =
            if goodEnough guess x then guess
            else sqrt_first (improve guess x) x

        sqrt_first x y


