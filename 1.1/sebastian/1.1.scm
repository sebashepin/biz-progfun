(define (ex1.2) (/ (+ 5 4 (- 2 (- 3 (+ 6 (/ 4 5) )))) (* 3 (- 6 2) (+ 2 (- 7)))))
(define (is-larger a b)(> a b))

(define (sum-of-largest-two a b c) 
  (cond ((is-larger a b)
         (+ a (cond ((is-larger b c) 
                     b)
                    (else c)
                    )
            )
         )
        (else
          (+ b (cond ((is-larger a c) a)
                     (else c)
                     )
             )
          )
        )
  )

(display "\nTranslate expression")
(newline)
(display (ex1.2))
(newline)
(display "\nSum of largest two")
(newline)
(display (sum-of-largest-two 1 2 3))