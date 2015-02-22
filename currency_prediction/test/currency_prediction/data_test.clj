(ns currency-prediction.data-test
  (:require [midje.sweet :refer :all]
            [currency-prediction.data :refer :all]))

;; (https://github.com/marick/Midje)
(fact "make-map giving expected hash-map"
      (make-map  ["2012-06-02 117.593703915"] ) => {"2012-06-02" "117.593703915"})