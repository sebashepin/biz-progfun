; 1.20
; (if (= 40 0) 206 (if (= (remainder 206 40) 0) 40 ( .....
; each step uses the previous (remainder) operation on its 'b' operator
; accumulating them. first execution has one remainder, second one has two times the previous one.
; And so on and so on. Therefore:
; executes (remainder) 2^k + 1 times on normal-order evaluation
; executes k times on applicative-order evaluation

(define (smallest-divisor n)
  (find-divisor n 2))

(define (find-divisor n test-divisor)
  (cond ((> (square test-divisor) n) 
         n)
        ((divides? test-divisor n) 
         test-divisor)
        (else (find-divisor 
               n 
               (+ test-divisor 1)))))

(define (divides? a b)
  (= (remainder b a) 0))

(define (prime? n)
  (= n (smallest-divisor n)))

(define (timed-prime-test n)
  (newline)
  (display n)
  (start-prime-test n (runtime)))

(define (start-prime-test n start-time)
  (cond ((prime? n)
      (report-prime (- (runtime) 
                       start-time)))
      (else #f)))

(define (report-prime elapsed-time)
  (display " *** ")
  (display elapsed-time)
  #t)


(define (search-for-primes range counter)
  (cond ((= counter 3)
         runtime)
        (else (cond ((timed-prime-test range) (search-for-primes (+ range 2) (+ counter 1)))
                    (else (search-for-primes (+ range 2) counter))
                    )
              )
        )
  )

