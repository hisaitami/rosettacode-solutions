(ns rosettacode-solutions.palindrome-detection-test
  (:require [clojure.test :refer :all])
  (:use [rosettacode-solutions.palindrome-detection]))

(deftest palindrome-detection-test
  (is (= true (palindrome? "level")))
  (is (not= true (palindrome? "hello")))
  (testing "it should work with integers"
    (is (= true (palindrome? 123456789987654321)))))

(deftest palindrome-seq-test
  (is (= (take 100 (filter palindrome? (iterate inc 0)))
         (take 100 (palindrome-seq 0)))))
