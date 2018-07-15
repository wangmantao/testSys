(defproject parse "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :injections [(require 'spyscope.core)]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [spyscope "0.1.6"]              ;; for debug
                 [org.clojure/tools.trace "0.7.9"]
                 [compliment "0.3.6"]])          ;; for complition
