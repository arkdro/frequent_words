(ns frequent_words.core
  {:doc "frequent words"}
  (:use clj-getopts.core)
  (:use clojure.tools.trace)
  (:require pattern_count.core)
  (:require frequent_words.find)
  (:gen-class)
  )

;;(trace-ns 'frequent_words.filter)

(defn -main [& args]
  (let [opts (getopts (options "is" {:infile :arg}) args)
        res (frequent_words.find/do-all-work opts)
        ]
    (println "res:" res)))

