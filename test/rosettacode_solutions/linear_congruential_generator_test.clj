(ns rosettacode-solutions.linear-congruential-generator-test
  (:require [clojure.test :refer :all])
  (:use [rosettacode-solutions.linear-congruential-generator]))

(deftest lcg-test
  (is (= 5 ((lcg 3 5 13) 0)))
  (testing "it should throw AssertionError if an invalid constant is given"
    (is (thrown-with-msg?
         AssertionError #"Assert failed: \(> m a\)"
         (lcg 3 5 3)))
    (is (thrown-with-msg?
         AssertionError #"Assert faild: \(> m b\)"
         (lcg 3 5 5)))
    (is (thrown-with-msg?
         AssertionError #"Assert failed: \(> a 0\)")
        (lcg 0 5 13))
    (is (thrown-with-msg?
         AssertionError #"Assert failed: \(>= b 0\)")
        (lcg 3 -1 13)))
)
