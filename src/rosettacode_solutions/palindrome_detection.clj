;; Task
;; @see https://rosettacode.org/wiki/Palindrome_detection

(ns rosettacode-solutions.palindrome-detection)

(defn palindrome? [s]
  (= (->> s str seq) (->> s str reverse)))

;(palindrome? 123456789987654321)
;;=> true

;(palindrome? "SATOR AREPO TENET OPERA ROTAS")
;;=> true

;; Unicode characters
;(palindrome? "NIψONANOMHMATAMHMONANOψIN")

;; Detect palindrome if white-space and punctuation is ignored and case-insensitive
;; (-> "No lemon, no melon"
;;     (clojure.string/replace #"[\s.,:;!?]+" "")   ; ignore white-space and punctuation
;;     (clojure.string/lower-case)                  ; case-insensitive comparison
;;     palindrome?)
;;=> true
