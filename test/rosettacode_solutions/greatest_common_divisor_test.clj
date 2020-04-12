(ns rosettacode-solutions.greatest-common-divisor-test
  (:require [clojure.test :refer :all]
            [rosettacode-solutions.greatest-common-divisor :refer [gcd]]))

(deftest gcd-test
  (is (= 1 (gcd 7 11)))
  (is (= 4 (gcd 4 12)))
  (is (= 14 (gcd 42 56))))
