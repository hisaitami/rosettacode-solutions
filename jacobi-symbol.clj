;; Task
;; @see https://rosettacode.org/wiki/Jacobi_symbol

(defn gcd [a b]
  (if (zero? b) a
      (gcd b (mod a b))))

(defn jacobi [a n]
  {:pre [(and (> n 0) (odd? n))]}
  (let [g (gcd a n)]
    (cond
      (or (= a 1) (= n 1)) 1
      (>= a n) (jacobi (mod a n) n)
      (= a 0) 0
      (= a 1) 1
      (neg? a) (let [x (/ (dec n) 2)
                     y (if (even? x) 1 -1)]
                 (* y (jacobi (- a) n)))
      (even? a) (let [x (/ (dec (* n n)) 8)
                      y (if (even? x) 1 -1)]
                  (* y (jacobi (/ a 2) n)))
      (= g a) 0
      (not= g 1) (* (jacobi g n) (jacobi (/ a g) n))
      (even? (/ (* (dec a) (dec n)) 4)) (jacobi n a)
      :else (- (jacobi n a)))))

(let [size 10
      odd-seq (filter odd? (range))]
  (->> (for [a (range 1 (inc size))
             n (take size odd-seq)]
         [a n])
       (sort-by second)
       (map (fn [[a n]] (jacobi a n)))
       (partition size)
       (zipmap (take size odd-seq))
       (sort-by key)
       (map println)))
;;=>
;;[1 (1 1 1 1 1 1 1 1 1 1)]
;;[3 (1 -1 0 1 -1 0 1 -1 0 1)]
;;[5 (1 -1 -1 1 0 1 -1 -1 1 0)]
;;[7 (1 1 -1 1 -1 -1 0 1 1 -1)]
;;[9 (1 1 0 1 1 0 1 1 0 1)]
;;[11 (1 -1 1 1 1 -1 -1 -1 1 -1)]
;;[13 (1 -1 1 1 -1 -1 -1 -1 1 1)]
;;[15 (1 1 0 1 0 0 -1 1 0 0)]
;;[17 (1 1 -1 1 -1 -1 -1 1 1 -1)]
;;[19 (1 -1 -1 1 1 1 1 -1 1 -1)]
