(ns rosettacode-solutions.math-test
  (:require [clojure.test :refer :all]
            [rosettacode-solutions.math :as math]))

(deftest square-test
  (is (= (map math/square (range -1 1 0.5))
         (map #(* % %) (range -1 1 0.5)))))

(deftest factorial-test
  (is (= (map math/factorial (range 10))
         [1 1 2 6 24 120 720 5040 40320 362880])))

(deftest gcd-test
  (is (= 1 (math/gcd 7 11)))
  (is (= 4 (math/gcd 4 12)))
  (is (= 14 (math/gcd 42 56))))

(deftest prime?-test
  (is (= (take 20 (filter math/prime? (range)))
         [2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71])))
