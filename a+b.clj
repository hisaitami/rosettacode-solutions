; Task
; @see https://rosettacode.org/wiki/A%2BB

(->> (clojure.string/split (read-line) #"\s+")
     (map #(Integer/parseInt %))
     (apply +)
     println)

;; usage
;; % clj a+b.clj
;; 2 2
;; 4
