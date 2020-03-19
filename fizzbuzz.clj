;; Task
;; @see https://rosettacode.org/wiki/FizzBuzz

(defn fizzbuzz [n]
  (cond
    (zero? (mod n 15)) "FizzBuzz"
    (zero? (mod n 3)) "Fizz"
    (zero? (mod n 5)) "Buzz"
    :else n))

(map fizzbuzz (range 1 101))
