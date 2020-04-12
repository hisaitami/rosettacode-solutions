;; Task
;; @see https://rosettacode.org/wiki/Sum_of_squares

(defn sum-of-squares [v]
  (apply + (map #(* % %) v)))

(sum-of-squares [1 2 3 4 5])
;=> 55

; The program should work on a zero-length vector with an answer of 0.
(sum-of-squares [])
;=> 0
