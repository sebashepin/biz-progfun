(ns week3.pascal-Test
  (:use clojure.test)
  (:use week3.pascal))

(deftest test-pascal-1-1
  (is (= 1 (pascal 1 1))))

(deftest test-pascal-3-2
  (is (= 2 (pascal 3 2))))

(deftest test-pascal-5-3
  (is (= 6 (pascal 5 3))))

(deftest test-pascal-5-3
  (is (= 2002 (pascal 15 10))))

(run-tests)
