(ns week1.exercises
  (:use clojure.test))

;1.1
(deftest test-10=10
  (is (= 10 10)))

(deftest test-5+3+4=12
  (is (= 12 (+ 5 3 4))))

(deftest test-9-1=8
  (is (= 8 (- 9 1))))

(deftest test-6div2=3
  (is (= 3 (/ 6 2))))

(deftest test-2*4+4-6=6
  (is (= 6 (+ (* 2 4) (- 4 6)))))

(defn a [] 3)
(defn b [] (+ (a) 1))

(deftest test-define-a
  (is (= 3 (a))))

(deftest test-define-b
  (is (= 4 (b))))

(deftest test-a+b+a*b=19
  (is (= 19 (+ (a) (b) (* (a) (b))))))

(deftest test-a-dif-b
  (is (= false (= (a) (b)))))

(deftest test-and
  (is (= 4 (if (and
                 (> (b) (a))
                 (< (b) (* (a) (b))))
             (b)
             (a)))))

(deftest test-cond
  (is (= 16 (cond
              (= (a) 4) 6
              (= (b) 4) (+ 6 7 (a))
              :else 25))))

(deftest test-if-with-expression
  (is (= 6 (+ 2 (if
                  (> (b) (a))
                  (b)
                  (a))))))

(deftest test-cond-with-expression
  (is (= 16 (* (cond
                 (> (a) (b)) (a)
                 (< (a) (b)) (b)
                 :else -1)
               (+ (a) 1)))))


;1.2
(deftest test-expression
  (is (= (- (/ 37 150))
         (/ (+ 5 4 (- 2 (- 3 (+ 6 (/ 4 5)))))
            (* 3 (- 6 2) (- 2 7))))))


;1.3
(defn square [x] (* x x))

(deftest test-square
  (is (= 9 (square 3)))
  (is (= 25 (square 5))))

(defn larger-number [x y] (cond (> x y) x :else y))

(defn square-sum
  ([x y] (+ (square x) (square y)))
  ([x y z] (if (> x y)
             (square-sum x (larger-number y z))
             (square-sum y (larger-number x z)))))

(deftest test-square-sum
  (is (= 34 (square-sum 2 3 5)))
  (is (= 34 (square-sum 5 2 3)))
  (is (= 34 (square-sum 3 5 2)))
  (is (= 34 (square-sum 5 3 2))))

;1.4
(defn a-plus-abs-b [a b] ((if (> b 0) + -) a b))

(deftest test-a-plus-abs-b
  (is (= 10 (a-plus-abs-b 5 5)))
  (is (= 10 (a-plus-abs-b 5 -5))))

;1.5
(defn p [] (p))
(defn test-p [x y]
  (if (= x 0)
    0
    (y)))

(test-p 0 p)
;(test-p 0 (p)) infinite recursion

;1.6

(defn average [x y] (/ (+ x y) 2))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn abs [x]
  (cond (< x 0) (- x) :else x))

(defn good-enough? [guess x]
  (< (abs (- (square guess) x)) 0.001))

(defn new-if [predicate then-clause else-clause]
  (cond predicate  then-clause :else else-clause))

(defn new-if-fn [predicate then-clause else-clause]
  (cond (predicate)  (then-clause) :else (else-clause)))

(defn sqrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x) x)))

; good enough with immediate execution
(defn sqrt-iter2 [guess x]
  (new-if (good-enough? guess x)
    guess
    (sqrt-iter2 (improve guess x) x)))

; good enough with annonimous functions
(defn sqrt-iter3 [guess x]
  (new-if-fn (fn [] (good-enough? guess x))
          (fn [] guess)
          (fn [] (sqrt-iter3 (improve guess x) x))))

(defn sqrt [x] (sqrt-iter3 1.0 x))

(defn sqrt2 [x]
  (defn good-enough2? [guess]
    (< (abs (- (square guess) x)) 0.001))
  (defn improve-2 [guess]
    (average guess (/ x guess)))
  (defn sqrt-iter-2 [guess]
    (if (good-enough2? guess)
      guess
      (sqrt-iter (improve-2 guess) x)))
  (sqrt-iter-2 1.0))

(deftest test-sqrt-9
  (is (= 3.00009155413138 (sqrt 9))))

(deftest test-sqrt2-9
  (is (= 3.00009155413138 (sqrt2 9))))

(run-tests)