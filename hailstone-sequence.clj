;; Task
;; @see https://rosettacode.org/wiki/Hailstone_sequence

(defn hailstone-seq
  "Returns the hailstone sequence from a starting positive integer n"
  [n]
  {:pre [(pos-int? n)]}
  (if (= n 1) [1]
      (let [nn (if (even? n) (/ n 2) (inc (* 3 n)))]
        (concat [n] (hailstone-seq nn)))))

;; Show the hailstone sequence for the number 27
(let [h27 (hailstone-seq 27)]
  {:length  (count h27)
   :starting-with (take 4 h27)
   :ending-with  (take-last 4 h27)
   })
;;=> {:length 112, :starting-with (27 82 41 124), :ending-with (8 4 2 1)}

;; Show the longest hailstone sequence number less than 100,000
(apply max-key :length (for [n (range 1 100000)]
                         {:hailstone n :length (count (hailstone-seq n))}))
;;=> {:hailstone 77031, :length 351}

