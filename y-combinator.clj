;; Task
;; @see https://rosettacode.org/wiki/Y_combinator

(defn Y [f]
  ((fn [x] (x x))
   (fn [x] (f #((x x) %)))))

(defn factorial [f]
  (fn [n]
    (if (zero? n)
      1
      (* n (f (dec n))))))

(defn fibonacci [f]
  (fn [n]
    (condp = n
      0 1
      1 1
      (+ (f (- n 2))
         (f (- n 1))))))

((Y factorial) 10)
;=> 3628800

(map (Y fibonacci) (range 10))
;=> (1 1 2 3 5 8 13 21 34 55)
