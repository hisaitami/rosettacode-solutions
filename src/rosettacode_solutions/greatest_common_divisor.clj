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

(defn coprime?
  ([a b] (= 1 (gcd a b)))
  ([a b c] (= 1 (gcd a b) (gcd b c) (gcd c a))))

;;(coprime? 729 1000)
;;=> true
