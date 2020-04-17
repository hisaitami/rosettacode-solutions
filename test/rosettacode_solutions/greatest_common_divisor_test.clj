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
    (is (true? (coprime? 0 -1))))
  (testing "two consecutive integers are coprime"
    (let [x 12]
      (is (true? (coprime? x (inc x))))))
  (testing "if x is coprime for each y1 and y2 then x is coprime to y1 * y2"
    (let [x 3 y1 5 y2 7]
      (is (true? (and (coprime? x y1)
                      (coprime? x y2)
                      (coprime? x (* y1 y2)))))))
  (testing "2^x - 1 and 2^y - 1 are coprime"
    (let [x 3 y 7]
      (is (true? (and (coprime? x y)
                      (coprime? (dec (bit-shift-left 1 x))
                                (dec (bit-shift-left 1 y)))))))))

(deftest pairwise-coprime?-test
  (is (true? (pairwise-coprime? 3 10 23)))
  (is (true? (pairwise-coprime? -3 10 23)))
  (is (true? (pairwise-coprime? 1 2 3 7 11 13)))
  (is (false? (pairwise-coprime? 1 2 3 7 11 13 11)))
  (is (false? (pairwise-coprime? 1 2 3 7 11 13 10)))
  (testing "it doesn't mean they are pairwise coprime, even if they are coprime"
    (let [a 3 b 15 c 10]
      (is (and
            (= 1 (gcd a b c))
            (false? (pairwise-coprime? a b c)))))))

(deftest phi-test
  (testing "phi numbers of 1 from 20"
    (is (= (map phi (range 1 21)) [1 1 2 2 4 2 6 4 6 4 10 4 12 6 8 8 16 6 18 8])))
  (testing "phi(p) = p-1 where p is prime"
    (let [p 1259]
      (is (= (dec p) (phi p)))))
  (testing "phi(n=p^k) = p^k * (1-1/p)"
    (let [p 2, k 3, n (reduce * (repeat k p))]
      (is (= (phi n)
             (* n (- 1 (/ 1 p)))))))
  (testing "phi(mn) = phi(m) * phi(n) when m and n are coprime"
    (let [m 34, n 55]
      (is (= (phi (* m n))
             (* (phi m) (phi n)))))))
