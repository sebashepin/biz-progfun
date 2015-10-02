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


