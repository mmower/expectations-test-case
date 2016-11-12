(ns test-case.core-test
  (:require [test-case.core :refer [unstable]]
            [expectations :refer [expect]]))

(try
  (macroexpand-1 '(unstable))
  (assert false)
  (catch Exception ex (println "Got an exception")))

(expect Exception (macroexpand-1 '(unstable)))
