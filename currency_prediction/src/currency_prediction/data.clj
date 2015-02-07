(ns currency-prediction.data
   (:require [clj-http.client :as client]))

(defn get-data []
 (client/get "http://currencies.apps.grandtrunk.net/getrange/2012-01-01/2015-01-01/eur/rsd"))

(get-data)

