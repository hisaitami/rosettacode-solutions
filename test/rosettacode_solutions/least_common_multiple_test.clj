(ns rosettacode-solutions.least-common-multiple-test
  (:require [clojure.test :refer :all]
            [rosettacode-solutions.least-common-multiple :refer [lcm]]))

(deftest lcm-test
  (is (= 36 (lcm 12 18)))
  (testing "it should return 0 if either a or b is 0"
    (is (= 0 (lcm 0 1)))
    (is (= 0 (lcm 1 0))))
  (testing "it should throw AssertError if both a and b are 0"
    (is (thrown-with-msg?
         AssertionError
         #"Assert failed: \(not= 0 a b\)"
         (lcm 0 0)))))
