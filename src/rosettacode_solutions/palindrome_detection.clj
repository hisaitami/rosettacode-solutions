;; Task
;; @see https://rosettacode.org/wiki/Palindrome_detection

(ns rosettacode-solutions.palindrome-detection)

(defn palindrome? [s]
  (= (->> s str seq) (->> s str reverse)))

;(palindrome? "SATOR AREPO TENET OPERA ROTAS")
;;=> true

;; Unicode characters
;;(palindrome? "NIψONANOMHMATAMHMONANOψIN")
;;=> true

;; Detect palindrome if white-space and punctuation is ignored and case-insensitive
;; (-> "No lemon, no melon"
;;     (clojure.string/replace #"[\s.,:;!?]+" "")   ; ignore white-space and punctuation
;;     (clojure.string/lower-case)                  ; case-insensitive comparison
;;     palindrome?)
;;=> true

(defn palindrome-seq [start]
  (let [->int #(if (empty? %) 0 (Integer/parseInt (apply str %)))
        ->seq #(-> % str seq)
        ->palindromic
        (fn [n]
          (if (palindrome? n) n
              (let [digits (->seq n)
                    length (count digits)
                    [head tail] (map ->int (split-at (/ length 2) digits))]
                (if (odd? length)
                  (let [s (-> (if (>= (/ head 10) tail) head (inc head)) ->seq)]
                    (->> (concat s (rest (reverse s))) ->int))
                  (let [s (-> (if (>= (-> head str butlast ->int)
                                      (-> tail str rest ->int))
                                head (inc head)) ->seq)]
                    (->> (concat s (reverse s)) ->int))))))
        next-number
        (fn [n]
          (let [digits (->seq n)]
            (if (every? #(= \9 %) digits) (+ n 2)
                (let [length (count digits)
                      head (->> digits (take (/ length 2)) ->int inc ->seq)
                      tail (reverse head)]
                  (-> (concat head (if (even? length) tail (rest tail))) ->int)))))
        ]
    (iterate next-number (-> start ->palindromic))))

;;(let [num 1000]
;;   (= (take num (filter palindrome? (iterate inc 0)))
;;      (take num (palindrome-seq 0))))
;;=> true

