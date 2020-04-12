(ns rosettacode-solutions.root-mean-square-test
  (:require [clojure.test :refer :all])
  (:use [rosettacode-solutions.root-mean-square]))

(deftest root-mean-square-test
  (is (= 2.8284271247461903 (rms [1 1 2 3 5]))))
