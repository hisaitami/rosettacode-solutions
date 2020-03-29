;; Task
;; @see https://rosettacode.org/wiki/Babbage_problem

(->> (range 1 99736)
     (filter (fn [x]
               (= 269696 (mod (* x x) 1000000))))
     (first))
;;=> 25264
