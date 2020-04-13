;; Task
;; @see https://rosettacode.org/wiki/Least_common_multiple

(ns rosettacode-solutions.least-common-multiple
  (:require [rosettacode-solutions.greatest-common-divisor :refer [gcd]]))

(defn lcm [a b]
  {:pre [(not= 0 a b)]}
  (/ (Math/abs (* a b)) (gcd a b)))

;;(lcm 12 18)
;;=> 36

;; returns 0 if either a or b is 0
;;(lcm 0 12)
;;=> 0
