;; Task
;; @see https://rosettacode.org/wiki/Babbage_problem

(->> (range 1 99736)
     (map (fn [x]
            (let [xx (* x x)
                  a (* (Math/floor (/ xx 1000000)) 1000000)
                  b (- xx 269696)]
              (if (= a b) x nil))))
     (drop-while nil?)
     (first))
;;=> 25264
