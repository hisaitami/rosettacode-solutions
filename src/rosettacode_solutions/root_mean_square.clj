;; Task
;; @see https://rosettacode.org/wiki/Averages/Root_mean_square

(ns rosettacode-solutions.root-mean-square
  (:use [rosettacode-solutions.sum-of-squares]))

(defn rms [xs]
  (Math/sqrt (/ (sum-of-squares xs) (count xs))))

;;(rms [1 1 2 3 5])
;;=> 2.8284271247461903
