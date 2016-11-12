(ns test-case.core)

(defmacro unstable []
  ; I explode
  (throw (Exception. "You were warned!")))
