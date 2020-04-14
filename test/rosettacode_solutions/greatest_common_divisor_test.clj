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
  (testing "only 1 and −1 are coprime to 0"
    (is (true? (coprime? 0 1)))
    (is (true? (coprime? 0 -1)))) ;; FIXME
  (testing "two consecutive integers are coprime"
    (let [x 12]
      (is (true? (coprime? x (inc x))))))
  (testing "if x is coprime for each y1 and y2 then x is coprime to b1 * b2"
    (let [x 3 y1 5 y2 7]
      (is (true? (and (coprime? x y1)
                      (coprime? x y2)
                      (coprime? x (* y1 y2))))))))

(deftest pairwise-coprime?-test
  (is (true? (pairwise-coprime? 3 10 23)))    
  (testing "it doesn't mean they are pairwise coprime, even if they are coprime"
    (let [a 3 b 15 c 10]
      (is (and
           (= 1 (gcd a b c))
           (false? (pairwise-coprime? a b c)))))))
