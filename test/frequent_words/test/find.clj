(ns frequent_words.test.find
  (:use [frequent_words.find])
  (:use [clojure.test]))

(deftest is-data-available-test
  (is (= true  (is-data-available 0 2 2)))
  (is (= false (is-data-available 1 2 2)))
  (is (= true  (is-data-available 1 3 2)))
  (is (= true  (is-data-available 2 3 1)))
  (is (= false (is-data-available 2 2 1)))
  (is (= false (is-data-available 1 1 1)))
  )

