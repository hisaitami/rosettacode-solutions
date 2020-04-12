;; Task
;; @see https://rosettacode.org/wiki/Greatest_common_divisor

(ns rosettacode-solutions.greatest-common-divisor)

(defn gcd [a b]
  (if (zero? b) a
      (gcd b (mod a b))))

;;(gcd 8 12)
;;=> 4

;;(gcd 1071 462)
;;=> 21
