;; Task
;; @see https://rosettacode.org/wiki/Averages/Root_mean_square

(ns rosettacode-solutions.root-mean-square
  (:require [rosettacode-solutions.math :as math]))

(defn rms [xs]
  (let [n (count xs)
        sigma (reduce + (map math/square xs))]
    (Math/sqrt (/ sigma n))))

;;(rms [1 1 2 3 5])
;;=> 2.8284271247461903
