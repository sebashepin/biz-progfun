(ns week3.pascal)

(defn pascal [row col]
  (cond (< col 0) 0
        (> col row) 0
        (= col 1) 1
        (= row col) 1
        :else (+ (pascal (- row 1) col)
                 (pascal (- row 1) (- col 1))))
  )

