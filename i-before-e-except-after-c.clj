;; Task
;; @see https://rosettacode.org/wiki/I_before_E_except_after_C

(def word-list-url "http://wiki.puzzlers.org/pub/wordlists/unixdict.txt")
;(def word-list-url "unixdict.txt")

(defn plausible? [x before y when-preceded-by z]
  {:pre [(and (= before :before)
              (= when-preceded-by :when-preceded-by))]}
  (->> (slurp word-list-url)
       (clojure.string/split-lines)
       (filter (partial re-matches (re-pattern (str ".+" x y ".*"))))
       (group-by #((comp not nil?) (re-matches (re-pattern (str ".*" z x y ".*")) %)))
       (reduce #(assoc %1 (first %2) (count (second %2))) {})
       ;(#(key (apply max-key val %)))
       ))

;; "I before E when not preceded by C"
(plausible? "i" :before "e" :when-preceded-by "[^c]")
;;=> {true 464, false 24}

;; "E before I when preceded by C"
(plausible? "e" :before "i" :when-preceded-by "c")
;;=> {false 194, true 13}
