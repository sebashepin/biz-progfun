(ns week1.sqrtTest
  (:use clojure.test)
  (:use week1.sqrt))

(deftest test-abs-0
  (is (= 0 (abs 0))))

(deftest test-abs-neg
  (is (= 3 (abs -3))))

(deftest test-abs-neg-not
  (is (not= -3 (abs -3))))

(deftest test-average-plus-0
  (is (= 4 (average 8 0))))

(deftest test-average-0
  (is (= 0 (average 0 0))))

(deftest test-average-neg
  (is (= 0 (average -8 8))))

(deftest test-square-0
  (is (= 0 (square 0))))

(deftest test-square-neg
  (is (= 4 (square -2))))

(deftest test-square-0
  (is (= 2.25 (square 1.5))))

(run-tests)