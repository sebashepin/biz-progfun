(ns week3.changeTest
  (:use clojure.test)
  (:use week3.change))

(deftest test-count-change
  (is (= 292 (count-change 100))))

(deftest test-count-change-2
  (is (= 4 (count-change 10))))

(run-tests)