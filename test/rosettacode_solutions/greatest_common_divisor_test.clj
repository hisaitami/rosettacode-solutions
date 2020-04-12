(ns rosettacode-solutions.greatest-common-divisor-test
  (:require [clojure.test :refer :all]
            [rosettacode-solutions.greatest-common-divisor :as math]))


(deftest gcd-test
  (is (= 1 (math/gcd 7 11)))
  (is (= 4 (math/gcd 4 12)))
  (is (= 14 (math/gcd 42 56))))
