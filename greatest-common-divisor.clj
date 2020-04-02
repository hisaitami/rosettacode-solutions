;; Task
;; @see https://rosettacode.org/wiki/Greatest_common_divisor

(defn gcd [a b]
  (let [x (mod a b)]
    (if (zero? x) b
        (gcd b x))))

;;(gcd 8 12)
;;=> 4

;;(gcd 1071 462)
;;=> 21
