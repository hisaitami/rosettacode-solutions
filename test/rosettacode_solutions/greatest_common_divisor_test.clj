(ns rosettacode-solutions.greatest-common-divisor-test
  (:require [clojure.test :refer :all])
  (:use [rosettacode-solutions.greatest-common-divisor]))

(deftest gcd-test
  (is (= 1 (gcd 7 11)))
  (is (= 4 (gcd 8 12)))
  (testing "it should work with two or more integers"
    (is (= 21 (gcd 1071 462 777)))
    (is (=  1 (gcd 1071 462 777 8)))))

(deftest coprime?-test
  (is (true? (coprime? 3 10)))
  (is (false? (coprime? 3 6)))
  (is (true? (coprime? 729 1000)))
  (is (false? (coprime? 729 1296)))
  (testing "it should work for pairwise coprime"
    (is (true? (coprime? 3 10 23)))    
    (is (false? (coprime? 3 15 10)))))
