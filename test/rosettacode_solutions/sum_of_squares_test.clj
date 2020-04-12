(ns rosettacode-solutions.sum-of-squares-test
  (:require [clojure.test :refer :all])
  (:use [rosettacode-solutions.sum-of-squares]))

(deftest sum-of-squares-test
  (is (= 55 (sum-of-squares [1 2 3 4 5])))
  (testing "it should work on a zero-length vector with an answer of 0"
    (is (= 0 (sum-of-squares [])))))
