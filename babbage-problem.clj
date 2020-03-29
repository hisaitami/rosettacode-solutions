;; Task
;; @see https://rosettacode.org/wiki/Babbage_problem

(->> (range 1 99736)
     (map (fn [x]
            (when (= 269696 (mod (* x x) 1000000)) x)))
     (drop-while nil?)
     (first))
;;=> 25264
