(ns rosettacode-solutions.greatest-common-divisor-test
  (:require [clojure.test :refer :all]
            [rosettacode-solutions.greatest-common-divisor :refer [gcd]]))

(deftest gcd-test
  (is (= 1 (gcd 7 11)))
  (is (= 4 (gcd 8 12)))
  (testing "it should work with two or more integers"
    (is (= 21 (gcd 1071 462 777)))
    (is (=  1 (gcd 1071 462 777 8)))))
