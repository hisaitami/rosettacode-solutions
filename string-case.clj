;; Task
;; @see https://rosettacode.org/wiki/String_case

(defn swapping-case [s]
  (let [->lower (fn [c] (+ c 32))
        ->upper (fn [c] (- c 32))
        lower? (fn [c] (and (>= c 97) (<= 122)))] ; between \a and \z?
    (->> (seq s)
         (map int)
         (map #(if (lower? %) (->upper %) (->lower %)))
         (map char)
         (apply str))))

(println
 (map #(% "alphaBETA") [clojure.string/upper-case
                        clojure.string/lower-case
                        clojure.string/capitalize
                        swapping-case]))
;; => (ALPHABETA alphabeta Alphabeta ALPHAbeta)
