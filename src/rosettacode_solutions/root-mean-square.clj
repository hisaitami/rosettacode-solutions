;; Task
;; @see https://rosettacode.org/wiki/Averages/Root_mean_square

(defn rms [xs]
  (let [n (count xs)
        sigma (apply + (map #(* % %) xs))]
    (Math/sqrt (/ sigma n))))

(rms (range 1 11))
