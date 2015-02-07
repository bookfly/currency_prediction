(ns currency-prediction.data
   (:require [clj-http.client :as client]))

(defn get-data-url []
  ;; Get currency change from 2012-2015 from web service
  ;; (http://currencies.apps.grandtrunk.net/)
  ;; @return Receive whole content
  (client/get "http://currencies.apps.grandtrunk.net/getrange/2012-01-01/2015-01-01/eur/rsd"))

#_(get-data-url)

(defn get-data-content []
  ;; Get currency change - only body with data 
  ;; (https://github.com/ring-clojure/ring/wiki/Concepts - Responses :body)
  ;; and split it on the separator \n for the new line
  ;; (https://clojuredocs.org/clojure.string/split-lines)
  ;; @return Receive pairs date-value as separate strings
     (try (clojure.string/split-lines (:body (get-data-url)))
       (catch Exception ex (str "Exception occured: " (.getMessage ex)))
       )
)

(get-data-content)

;;TODO
;; Received data put into map
;; key is the date
;; value is the value


