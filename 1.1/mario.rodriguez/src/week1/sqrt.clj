(ns week1.sqrt)

;Utilitary functions
(defn abs [x]
  (if (< x 0) (- x) x))

(defn average [x y]
  (/ (+ x y) 2))

(defn square [x] (* x x))

;1.3
(defn maximum [x y z]
  (cond (and (>= x y) (>= x z)) x
        (and (>= y x) (>= y z)) y
        :else z))

(defn medium [x y z]
  (cond (or (and (>= x y) (<= x z))
            (and (<= x y) (>= x z))) x
        (or (and (>= y x) (<= y z))
            (and (<= y x) (>= y z))) y
        :else z))

(defn multi [x y z]
  (+ (square (maximum x y z))
     (square (medium x y z))))

;1.4
(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b)
  )

;sqrt
(defn good-enough? [guess x]
  (< (abs (- (square guess) x)) 0.0001))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn sqrt-iter [guess x]
  (if (good-enough? guess x) guess (sqrt-iter (improve guess x) x)
                             ))

(defn sqrt [x] (sqrt-iter 1.0 x))

(sqrt 4)

;sqrt2
(defn sqrt2 [x]
  (defn improve2 [guess]
    (average guess (/ x guess)))
  (defn good-enough2? [guess]
    (< (abs (- (square guess) x)) 0.0001))
  (defn try2 [guess]
    (if (good-enough2? guess) guess (try2 (improve2 guess)))
    )
  (try2 1.0)
  )

;sqrt3
(defn sqrt3 [x]
  (defn improve3 [guess]
    (average guess (/ x guess)))
  (defn good-enough3? [a b]
    (< (abs (/ (- a b) b)) 0.0001))
  (defn try3 [guess-new guess-old]
    (if (good-enough3? guess-new guess-old) guess-new (try3 (improve3 guess-new) guess-new))
    )
  (try3 1.0 x)
  )

;cubic-root
(defn cubic-root [x]
  (defn improve4 [guess]
    (/ (+ (/ x (* guess guess)) (* 2 guess)) 3 )
    )
  (defn good-enough4? [guess]
    (< (abs (- (square guess) x)) 0.0001))
  (defn try4 [guess]
    (if (good-enough4? guess) guess (try4 (improve4 guess)))
    )
  (try4 1.0))

;cubic-root2
(defn cubic-root2 [x]
  (defn improve5 [y]
    (/ (+ (/ x (square y)) (* 2 y)) 3 )
    )
  (defn good-enough5? [a b]
    (< (abs (/ (- a b) b)) 0.0001))
  (defn try5 [guess-new guess-old]
    (if (good-enough5? guess-new guess-old) guess-new (try5 (improve5 guess-new) guess-new))
    )
  (try5 1.0 x))

