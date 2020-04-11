;; Task
;; @see https://rosettacode.org/wiki/Jacobi_symbol

(defn gcd [a b]
  (if (zero? b) a
      (gcd b (mod a b))))

(defn prime? [n]
  (cond
    (<= n 1) false
    (= n 2) true
    (even? n) false
    :else (->> (filter odd? (range 3 n))
               (map #(mod n %))
               (not-any? zero?))))

;;(def prime-seq (filter prime? (range)))
;;(take 20 prime-seq)
;;=> (2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71)

;; quadratic residues
(defn qr [a p]
  {:pre [(prime? p)]}
  (= 1.0
     (mod (Math/pow a (/ (dec p) 2))
          p)))

;(map #(qr % 7) (range 10))
;;=> (false true true false true false false false true true)

;; legendre symbol
(defn legendre [a p]
  {:pre [(and (odd? p) (prime? p))]}
  (cond
    (not= 1 (gcd a p)) 0
    (true? (qr a p)) 1
    :else -1))

;;(map #(legendre % 7) (range 10))
;;=> (0 1 1 -1 1 -1 -1 0 1 1)

(defn jacobi [a n]
  {:pre [(and (> n 0) (odd? n))]}
  (cond
    (or (= a 1) (= n 1)) 1
    (or (> 0 a) (> a n)) (jacobi (mod a n) n)
    (not= 1 (gcd a n)) 0
    (prime? n) (legendre a n)
    (even? a) (let [x (/ (dec (* n n)) 8)
                    y (if (even? x) 1 -1)]
                (* y (jacobi (/ a 2) n)))
    (even? (/ (* (dec a) (dec n)) 4)) (jacobi n a)
    :else (- (jacobi n a))))

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
