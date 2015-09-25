;Exercises

; =======================================================
; Exercise 1.9 - Iteration vs Recursion
; =======================================================

; inc(+ dec(4) 5)
; inc(+ 3 5)
; inc(inc(+ 2 5))
; inc(inc(inc(+ 1 5)))
; inc(inc(inc(inc(+ 0 5))))
; inc(inc(inc(inc 5)))
; inc(inc(inc 6 ))
; inc(inc 7 )
; inc( 8 )
; 9
; The process is linear-recursive

; (+ (dec 4) (inc 5) )
; (+ (dec 3) (inc 6) )
; (+ (dec 2) (inc 7) )
; (+ (dec 1) (inc 8) )
; 9
; This process is linear-iterative/tail-recursive

; =======================================================
; Exercise 1.10 - Ackermann's function
; =======================================================

; (A 1 10)
; (A 0 (A 1 9))
; (A 0 (A 0 (A 1 8
; 1024

; (A 2 4)
; (A 1 (A 2 3))
; (A 1 (A 1 A(2 2))) THIS IS INSANITY
; (A 1 (A 1 (A 1 (A 2 1))))
; (A 1 (A 1 (A 1 2)))
; (A 1 (A 1 (A 0 (A 1 1))))
; (A 1 (A 1 (A 0 2)))
; (A 1 (A 1 4))
; 2^16 = 65536 SHIT

; (A 3 3)
; (A 2 (A 3 2))
; (A 2 (A 2 (A 3 1)))
; (A 2 (A 2 2))
; (A 2 (A 1 (A 2 1)))
; (A 2 (A 1 2))
; (A 2 4)
; 65536

; (f n) computes 2n
; (g n) computes 2^n
; (g n) computes n∨2 (tetration, had to look that shit up)

; =======================================================
; Exercise 1.11 - Recursive/Iterative function
; =======================================================

; Recursive
(define (f11 n) 
  (cond ((< n 3)
          n)
         (else (+
                 (f11 (- n 1))
                 (* 2 (f11 (- n 2)))
                 (* 3 (f11 (- n 3)))
                 )
               )
         )
   
  )

;Iterative
(define (f11-iter-start n)
  (f11-iter n 2 1 0)
  )

(define (f11-iter n n-1 n-2 n-3)
  (let ((currentValue (+
                        n-1
                        (* 2 n-2)
                        (* 3 n-3)
                        )
                      ))

    (cond ((<= n 3) currentValue)
          (else
            (f11-iter 
              (- n 1)
              currentValue
              n-1
              n-2
              )
            )
          )
    )
  )

; =======================================================
; Exercise 1.12 - Pascal's triangle
; =======================================================

(define (pascal row column)
  (cond ((or (= column 1) (= column row)) 1)
        (else (+ 
                (pascal (- row 1) (- column 1))
                (pascal (- row 1) column)
                )
              )
        )
  )

;Printing
(define (printProc name function)
  (display newline)
  (display name)
  (display (function))
  )

