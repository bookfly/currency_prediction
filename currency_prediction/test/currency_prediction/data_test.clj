(ns currency-prediction.data-test
  (:require [midje.sweet :refer :all]
            [currency-prediction.data :refer :all]))

(fact "string"
      (make-map  ["2012-06-02 117.593703915"] ) => {"2012-06-02" "117.593703915"})