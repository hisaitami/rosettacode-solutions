;; Task
;; @see https://rosettacode.org/wiki/Order_two_numerical_lists

(defn lexicographic-order? [x y]
  (> 1 (compare x y)))

(lexicographic-order? [1 2 3] [1 2 4])
;;=> true

(lexicographic-order? [1 2 3] [1 2 3 4])
;;=> true

(lexicographic-order? [1 2 3 4] [1 2 3])
;;=> false

