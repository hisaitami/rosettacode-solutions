;; Task
;; @see https://rosettacode.org/wiki/Linear_congruential_generator

(ns rosettacode-solutions.linear-congruential-generator)

(defn lcg [a c m]
  (fn [r_n]
    (mod (+ (* a r_n) c) m)))

(defn bsd-formula [n]
  (let [seed 0
        state (lcg 1103515245 12345 2147483647)]
    (nth (iterate state seed) n)))

;;(map bsd-formula (range 1 10))
;;=> (12345 1406938949 178066070 1543701248 427461576 562845833 1609490218 377220791 2040027864)

;;(apply (juxt min max) (map bsd-formula (range 10000)))
;;=> [0 2147386121]

(defn ms-formula [n]
  (let [seed 0
        state (lcg 214013 2531011 2147483647)]
    (quot (nth (iterate state seed) n) 65536)))

;;(map ms-formula (range 1 10))
;;=> (38 7719 22062 24862 18419 7459 11489 21752 14862)

;;(apply (juxt min max) (map ms-formula (range 10000)))
;;=> [0 32767]
