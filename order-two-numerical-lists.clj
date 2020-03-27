;; Task
;; @see https://rosettacode.org/wiki/Order_two_numerical_lists

(defn order-lexicographic?
  "Return true if the first list should be ordered before the second, otherwise false.
   The order is determined by lexicographic order."
  [coll1 coll2]
  (if (> (count coll1) (count coll2)) false ; return false if the second list run out of elements
      (every? true? (map <= coll1 coll2))))

(order-lexicographic? [1 2 3] [1 2 4])
;;=> true

(order-lexicographic? [1 2 3] [1 2 3 4])
;;=> true

(order-lexicographic? [1 2 3 4] [1 2 3])
;;=> false

