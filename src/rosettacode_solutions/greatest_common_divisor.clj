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
