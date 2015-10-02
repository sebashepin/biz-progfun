(ns week3.exercise-1-11-Test
  (:use clojure.test)
  (:use week3.exercise-1-11))

(deftest test-f-recursive-2
  (is (= 2 (f-recursive 2))))

(deftest test-f-iterative-2
  (is (= 2 (f-iterative 2))))

(deftest test-f-recursive-3
  (is (= 4 (f-recursive 3))))

(deftest test-f-iterative-3
  (is (= 4 (f-iterative 3))))

(deftest test-f-recursive-4
  (is (= 11 (f-recursive 4))))

(deftest test-f-iterative-4
  (is (= 11 (f-iterative 4))))

(deftest test-f-recursive-10
  (is (= 1892 (f-recursive 10))))

(deftest test-f-iterative-10
  (is (= 1892 (f-iterative 10))))

(run-tests)