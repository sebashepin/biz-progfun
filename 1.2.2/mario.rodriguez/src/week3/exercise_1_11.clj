(ns week3.exercise-1-11)

(defn newIfOld [i t e]
  (if (i) (t) (e)))

(defn newIf [i t e]
  (cond (i) (t)
        :else (e)))

(defn f-recursive [n]
  (cond (< n 3) n
        :else (+ (f-recursive (- n 1))
                 (* 2 (f-recursive (- n 2)))
                 (* 3 (f-recursive (- n 3)))
                 )
        ))

(defn f-iterative [n]
  (defn f-n [f1 f2 f3]
    (+ f1 (* 2 f2) (* 3 f3)))

  (defn f-iter [f1 f2 f3 count]
    (newIf
      (fn [] (> count n))
      (fn [] f1)
      (fn [] (f-iter (f-n f1 f2 f3) f1 f2 (+ count 1)))))

  (newIf
    (fn [] (< n 3))
    (fn [] n)
    (fn [] (f-iter 2 1 0 3))))

