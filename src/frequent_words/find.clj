(ns frequent_words.find
  ;; (:use clojure.tools.trace)
  )

;;(trace-ns 'frequent_words.find)

(defn is-data-available [i len k]
  (let [end (+ i k)]
    (<= end len)))

(defn add-one-k-mer [i text k acc]
  (let [end (+ i k)
        k-mer (subs text i end)
        new-acc (update-in acc [k-mer] (fnil inc 0))]
    new-acc))

(defn iter-over-text-aux [i text k acc]
  (if (is-data-available i (count text) k)
    (recur (inc i) text k (add-one-k-mer i text k acc))
    acc))

(defn iter-over-text [text k]
  (iter-over-text-aux 0 text k {}))

(defn find-max-items [data]
  (let [max-val (second (apply max-key val data))
        items (filter #(= (val %) max-val) data)
        ks (map first items)
        sorted (sort ks)]
    sorted))

(defn do-all-work [opts]
  (let [[text k-str] (pattern_count.core/read-data opts)
        k (Integer/parseInt k-str)
        freq-data (iter-over-text text k)
        res (find-max-items freq-data)
        ]
    res))

