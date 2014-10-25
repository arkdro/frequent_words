(ns frequent_words.core
  {:doc "frequent words"}
  (:use clj-getopts.core)
  (:use clojure.tools.trace)
  (:require pattern_count.core)
  (:gen-class)
  )

;;(trace-ns 'frequent_words.filter)

(defn -main [& args]
  (let [opts (getopts (options "is" {:infile :arg
                                     :k k
                                     :skip :arg}) args)
        res (pattern_count.core/read-data opts)
        ]
    (println "res:" res)))

