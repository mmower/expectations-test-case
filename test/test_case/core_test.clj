(ns test-case.core-test
  (:require [test-case.core :refer [unstable]]
            [expectations :refer [expect]]))

(try
  (macroexpand-1 '(unstable))
  (assert false)
  (catch Exception ex (println "Got an exception")))

;; because of quoting and the macro expansion of expect itself, this does not work:
;; (expect Exception (macroexpand-1 '(unstable)))
;; but both of these do (note the ` instead of ' in the second one):
(expect Exception (macroexpand-1 '(test-case.core/unstable)))
(expect Exception (macroexpand-1 `(unstable)))

;Alia:test-case matt$ lein autoexpect
;
;*********************************************
;*************** Running tests ***************
;:reloading (test-case.core test-case.core-test)
;Got an exception
;
;failure in (core_test.clj:10) : test-case.core-test
;(expect Exception (macroexpand-1 '(unstable)))
;
;           (macroexpand-1 (quote (unstable))) did not throw Exception
;
;Ran 1 tests containing 1 assertions in 18 msecs
;1 failures, 0 errors.
;Tests completed at 10:34:30.591
