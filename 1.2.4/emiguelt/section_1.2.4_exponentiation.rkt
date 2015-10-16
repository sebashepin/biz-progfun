;; expt (basic)

(define (expt b n)
  (if (= n 0)
      1
      (* b (expt b (- n 1)))))

;; expt (iterative)
(define (exptit b n)
  (define (expt-iter counter product)
    (if (= counter 0)
        product
	(expt-iter (- counter 1) (* b product))))
  (expt-iter n 1))

;; expt (fast - recursive)
(define (even? n)
  (= (remainder n 2 ) 0))

(define (fast-expt b n)
  (cond ((= n 0) 1)
        ((even? n) (square (fast-expt b (/ n 2))))
	(else (*b (fast-expt b (- n 1))))))

;; Exercise 1.16 Define an iterative algorithm for fast-expt
(define (fast-exptit b n)
  (define (fast-expt-iter b n p)
    (cond ((= n 0) p)
          ((even? n) (fast-expt-iter (* b b) (/ n 2 ) p))
          (else (fast-expt-iter b (- n 1) (* b p)))))
  (fast-expt-iter b n 1))

(fast-exptit 2 0)
(fast-exptit 2 1)
(fast-exptit 2 2)
(fast-exptit 2 3)

(fast-exptit 5 0)
(fast-exptit 5 1)
(fast-exptit 5 2)
(fast-exptit 5 3)

;; Exercise 1.17 Use a similar algorithm of fast-expt for multiplication using repeated additions
(define (*1 a b)
  (print "I")
  (if (= b 0 )
    0
    (+ a (*1 a (- b 1)))))

;;;; Multiplication iterative
(define (*2 a b)
  (print "I")
  (define (*-iter a b s)
    (if (= b 0 )
      s
      (*-iter a (- b 1) (+ a s))))

  (*-iter a b 0))

;;;; Multiplication using double and halve
(define (doubles a) (+ a a))
(define (halves a) (/ a 2))

;;;;;; recursive
(define (*3 a b)
  (print "I")
  (cond ((= b 0 ) 0)
        ((even? b) (*3 (doubles a) (halves b)))
        (else (+ a (*3 a (- b 1))))))

;; Exercise 1.18 Use 1.16 and 1.17 to create an iterative algorithm for multiplication based on adding, doubling and halving

(define (*4 a b)
  (define (*-iter a b s)
    (print "I")
    (cond ((= b 0) s)
          ((even? b) (*-iter (doubles a) (halves b) s))
          (else (*-iter a (- b 1) (+ a s)))))

  (*-iter a b 0))

(print "basic")
(*1 2 3)
(*1 7 8)
(*1 2 50)
(*1 2 1000)
(print "basic-iterative")
(*2 2 3)
(*2 7 8)
(*2 2 50)
(*2 2 1000)
(print "double/halve recursive")
(*3 2 3)
(*3 7 8)
(*3 2 50)
(*3 2 1000)
(print "doube/halve iterative")
(*4 2 3)
(*4 7 8)
(*4 2 50)
(*4 2 1000)

