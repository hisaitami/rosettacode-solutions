;; Task
;; @see https://rosettacode.org/wiki/Eban_numbers

;; Only numbers less than one sextillion (10^21) will be considered in/for this task.
(def spelling-numbers
  {0 "zero"
   1 "one"
   2 "two"
   3 "three"
   4 "four"
   5 "five"
   6 "six"
   7 "seven"
   8 "eight"
   9 "nine"
   10 "ten"
   11 "eleven"
   12 "twelve"
   13 "thirteen"
   14 "fourteen"
   15 "fifteen"
   16 "sixteen"
   17 "seventeen"
   18 "eighteen"
   19 "nineteen"
   20 "twenty"
   30 "thirty"
   40 "forty"
   50 "fifty"
   60 "sixty"
   70 "seventy"
   80 "eighty"
   90 "ninety"
   100 "one hundred"
   1000 "one thousand"
   1000000 "one million"
   1000000000 "one billion"
   1000000000000 "one trillion"
   1000000000000000 "one quadrillion"
   1000000000000000000 "one quintillion"
   1000000000000000000000 "one sextillion"})

(defn count-in-english [n]
  (cond
    (contains? spelling-numbers n) (spelling-numbers n)
    (and (> n 20) (< n 100))
    (str (count-in-english (* (quot n 10) 10)) " " (count-in-english (mod n 10)))
    (and (> n 100) (< n 1000))
    (str (count-in-english (quot n 100)) " hundred"
         (when (> (mod n 100) 0) (str " " (count-in-english (mod n 100)))))
    (and (> n 1000) (< n 1000000))
    (str (count-in-english (quot n 1000)) " thousand"
         (when (> (mod n 1000) 0) (str " " (count-in-english (mod n 1000)))))
    (and (> n 1000000) (< n 1000000000))
    (str (count-in-english (quot n 1000000)) " million"
         (when (> (mod n 1000000) 0) (str " " (count-in-english (mod n 1000000)))))
    (and (> n 1000000000) (< n 1000000000000))
    (str (count-in-english (quot n 1000000000)) " billion"
         (when (> (mod n 1000000000) 0) (str " " (count-in-english (mod n 1000000000)))))
    (and (> n 1000000000000) (< n 1000000000000000))
    (str (count-in-english (quot n 1000000000000)) " trillion"
         (when (> (mod n 1000000000000) 0) (str " " (count-in-english (mod n 1000000000000)))))
    (and (> n 1000000000000000) (< n 1000000000000000000))
    (str (count-in-english (quot n 1000000000000000)) " quadrillion"
         (when (> (mod n 1000000000000000) 0) (str " " (count-in-english (mod n 1000000000000000)))))
    (and (> n 1000000000000000000) (< n 1000000000000000000000))
    (str (count-in-english (quot n 1000000000000000000)) " quintillion"
         (when (> (mod n 1000000000000000000) 0) (str " " (count-in-english (mod n 1000000000000000000)))))
    (and (> n 1000000000000000000000) (< n 1000000000000000000000000))
    (str (count-in-english (quot n 1000000000000000000000)) " sextillion"
         (when (> (mod n 1000000000000000000000) 0) (str " " (count-in-english (mod n 1000000000000000000000)))))))

(defn eban
  ([end] (eban 1 end))
  ([start end] (->> (range start (inc end))
                    (map (fn [n] [n (count-in-english n)]))
                    (remove (fn [v] (contains? (set (second v)) \e)))
                    (map first))))

;; show all eban numbers   ≤   1,000   (in a horizontal format),   and a count
;;(println (eban 1000))
;;=> (2 4 6 30 32 34 36 40 42 44 46 50 52 54 56 60 62 64 66)

;; show all eban numbers between   1,000   and   4,000   (inclusive),   and a count
;;(println (eban 1000 4000))
;;=> (2000 2002 2004 2006 2030 2032 2034 2036 2040 2042 2044 2046 2050 2052 2054 2056 2060 2062 2064 2066 4000)

;; show a count of all eban numbers up and including      10,000
;;(println (count  (eban 10000)))
;;=> 79

;; show a count of all eban numbers up and including     100,000
;;(println (count (eban 100000)))
;;=> 399

;; show a count of all eban numbers up and including   1,000,000
;;(println (count (eban 1000000)))
;;=> 399

;; show a count of all eban numbers up and including  10,000,000
;;(println (count (eban 10000000)))
;;=> 1599

;; show all output here.
;;(println  (count (eban 1000000000)))
;;=> 7999
