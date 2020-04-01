; Task
; @see https://rosettacode.org/wiki/A%2BB

(->> (clojure.string/split (read-line) #"\s+")
     (reduce #(+ %1 (Integer/parseInt %2)) 0)
     println)

;; usage
;; % clj a+b.clj
;; 2 2
;; 4
