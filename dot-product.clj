;; Task
;; @see https://rosettacode.org/wiki/Dot_product

(defn dot-product [v1 v2]
  {:pre [(= (count v1) (count v2))]} ; each vector must be the same length
  (apply + (map * v1 v2)))
  
(dot-product [1 3 -5] [4 -2 -1])
  
