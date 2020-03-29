;; Task
;; @see https://rosettacode.org/wiki/Babbage_problem

(->> (range 1 99737) ; Babbage thought the answer might be 99736
     (filter #(= 269696 (mod (* % %) 1000000))))
;;=> (25264 99736)

(def babbage-seq (filter #(= 269696 (mod (* % %) 1000000)) (range)))
(first babbage-seq)
;;=> 25264
