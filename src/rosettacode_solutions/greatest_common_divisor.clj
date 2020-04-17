;; Task
;; @see https://rosettacode.org/wiki/Greatest_common_divisor

(ns rosettacode-solutions.greatest-common-divisor)

(defn gcd
  ([a] a)
  ([a b]
   (if (zero? b) a
     (gcd b (mod a b))))
  ([a b & more]
   (apply gcd (gcd a b) more)))

;;(gcd 8 12)
;;=> 4

(defn coprime? [a b]
  (= 1 (Math/abs (gcd a b))))

;;(coprime? 729 1000)
;;=> true

(defn pairwise-coprime? [& coll]
  (->> (map-indexed vector coll)
       (map (fn [[i x]] [x (drop (inc i) coll)]))
       (butlast)
       (mapcat (fn [[x ys]] (map (partial coprime? x) ys)))
       (every? true?)))

;;(pairwise-coprime? 1 2 3 7)
;;=>true
;;(pairwise-coprime? 1 2 3 10)
;;=>false

(defn phi
  "Counts the positive integers up to n that are relatively prime to n."
  [n]
  {:pre [(pos-int? n)]}
  (->> (range 1 (inc n))
       (filter (partial coprime? n))
       (count)))

;;(map phi (range 1 (inc 30)))
;;=> (1 1 2 2 4 2 6 4 6 4 10 4 12 6 8 8 16 6 18 8 12 10 22 8 20 12 18 12 28 8)
