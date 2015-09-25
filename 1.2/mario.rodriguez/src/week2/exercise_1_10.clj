(ns week2.exercise-1-10)

(defn A [x y]
  (cond (= y 0) 0
        (= x 0) (* 2 y)
        (= y 1) 2
        :else (A (- x 1) (A x (- y 1))))
  )