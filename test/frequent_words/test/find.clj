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

(deftest add-one-k-mer-test
  (is (= {"qwe" 1} (add-one-k-mer 0 "qwer" 3 {})))
  (is (= {"qwe" 2 "asd" 3} (add-one-k-mer 0 "qwer" 3 {"qwe" 1 "asd" 3})))
  (is (= {"wer" 1 "asd" 3} (add-one-k-mer 1 "qwer" 3 {"asd" 3})))
  )

(deftest iter-over-text-test
  (is (= {"qwe" 1 "wea" 1 "eas" 1 "asd" 1} (iter-over-text "qweasd" 3)))
  (is (= {"asa" 3 "sas" 2} (iter-over-text "asasasa" 3)))
  (is (= {"asas" 3 "sasa" 2} (iter-over-text "asasasas" 4)))
  )

(deftest find-max-items-test
  (is (= ["asas"] (find-max-items {"asas" 2 "sasa" 1})))
  (is (= ["sasa"] (find-max-items {"asas" 1 "sasa" 2})))
  (is (= ["asas" "sasa"] (find-max-items {"asas" 3 "sasa" 3})))
  )

