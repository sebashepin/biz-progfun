(ns week2.factorial
  (:use clojure.test))

(defn factorial [n]
  (cond (= n 1) 1
        :else (* n (factorial (- n 1)))))

(defn tail-factorial [n]
  (defn factorial-iter [x acum]
    (cond
      (= x 1) acum
      :else (factorial-iter (- x 1) (* x acum))))
  (factorial-iter n 1))

(deftest test-factorial
  (is (= 120 (factorial 5)))
  (is (= 6 (factorial 3))))

(deftest test-tail-factorial
  (is (= 120 (tail-factorial 5))))



(run-tests)