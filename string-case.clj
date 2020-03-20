;; Task
;; @see https://rosettacode.org/wiki/String_case

(defn swapping-case [s]
  (let [->lower #(+ % 32)
        ->upper #(- % 32)
        lower? #(and (>= % 97) (<= % 122)) ; between \a and \z?
        upper? #(and (>= % 65) (<= % 90))  ; between \A and \Z?
        swap #(cond
                (lower? %) (->upper %)
                (upper? %) (->lower %)
                :else %)]
    (->> (seq s)
         (map (comp char swap int))
         (apply str))))

(println
 (map #(% "alphaBETA") [clojure.string/upper-case
                        clojure.string/lower-case
                        clojure.string/capitalize
                        swapping-case]))
;; => (ALPHABETA alphabeta Alphabeta ALPHAbeta)
