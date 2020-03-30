;; Task
;; @see https://rosettacode.org/wiki/Calculating_the_value_of_e

(defn factorial [n]
  (reduce * (range 1 (inc n))))

(def e
  (->> (range 1 20)
       (reduce #(+ %1 (/ 1 (factorial %2))) 1.0)))

(println e)
;;=> 2.7182818284590455
