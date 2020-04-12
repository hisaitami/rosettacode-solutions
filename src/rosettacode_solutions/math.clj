(ns rosettacode-solutions.math)

(defn square [x]
  (* x x))

(defn factorial [n]
  {:pre [(or (zero? n) (pos-int? n))]}
  (reduce * (range 1 (inc n))))

(defn prime? [n]
  (cond
    (<= n 1) false
    (= n 2) true
    (even? n) false
    :else (->> (filter odd? (range 3 n))
               (map #(mod n %))
               (not-any? zero?))))
