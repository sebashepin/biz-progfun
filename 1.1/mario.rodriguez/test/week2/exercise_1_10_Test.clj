(ns week2.exercise-1-10-Test
  (:use clojure.test)
  (:use week2.exercise-1-10))

(deftest test-a
  (is (= 1024 (A 1 10)))
  (is (= 65536 (A 2 4)))
  (is (= 65536 (A 3 3)))
  )

(run-tests)