; Fibonacci tree recursive

(define (fibtr n)
  (cond ((= n 0) 0)
        ((= n 1) 1)
        (else (+ (fibtr (- n 1))
                 (fibtr (- n 2))))))

(fibtr 5)
; 5
(fibtr 6)
;6

; Fibonacci iterative

(define (fibit n)
  (define (fib-iter a b count)
    (if (= count 0)
      b
      (fib-iter (+ a b) a (- count 1))))

  (fib-iter 1 0 n)
  )

(fibit 5)
;5
(fibit 6)
;6
;;;;;;;;;;;;;;;;;;;;;;;
; Example counting change

(define (count-change amount)
  (define (cc amount kinds-of-coins)
    (cond ((= amount 0 ) 1)
          ((or (< amount 0) (= kinds-of-coins 0)) 0)
          (else (+ (cc amount
                       (- kinds-of-coins 1))
                   (cc (- amount
                          (first-denomination kinds-of-coins))
                       kinds-of-coins)))))
  (define (first-denomination kinds-of-coins)
    (cond ((= kinds-of-coins 1) 1)
          ((= kinds-of-coins 2) 5)
          ((= kinds-of-coins 3) 10)
          ((= kinds-of-coins 4) 20)
          ((= kinds-of-coins 5) 50)))

  (cc amount 5)
  )

(count-change 10)
;4

(count-change 100)
;292

;;;;;;;;;;;;;;;;
;;; Exercise 1.11

(define (f n)
     (define (sum a b c) (+ a (* 2 b) (* 3 c)))
     (define (iterf a b c n)
          (cond ((< n 3) (sum a b c))
                (else (iterf (sum a b c) a b (- n 1)))))
     (cond ((< n 3) n)
           (else (iterf 2 1 0 (- n 1)))))


(f 1)
(f 2)
(f 3)
(f 4)
(f 5)
(f 6)

;;;;;;;;;;;;;;;;
;;; Exercise 1.12 Pascal (modified)
;;; 1
;;; 1 1
;;; 1 2 1
;;; 1 3 3 1
;;; 1 4 6 4 1

(define (pascal x y)
  (cond ((= x 0) 1)
        ((and (= y 0) (= x 0) 1))
        (else (pascal (dec x)(dec y) )
              (pascal x (dec y)))))

(pascal 0 0)
(pascal 0 1)
(pascal 1 2)
(pascal 2 3)
(pascal 3 4)

