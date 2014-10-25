(defproject frequent_words "1.0.0-SNAPSHOT"
  :description "frequent words. Bioinformatics algorithms"
  :main frequent_words.core
  :extra-classpath-dirs [
                         ".lein-git-deps/pattern_count/src"
                         ]
  :dependencies [
                  [org.clojure/clojure "1.4.0"]
                  [clj-getopts "0.0.2"]
                  [org.clojure/tools.trace "0.7.5"]
                ])

