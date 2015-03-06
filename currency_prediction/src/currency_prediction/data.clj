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

#_(get-data-content)

;; get-data-content returns vector with key-value strings
;; first get a string and split it at blankspace,
;; then make hash-map and put
;; first part as key (date)
;; second as value (decimal number)
(defn make-map [data]
  ;; put into map
  ;; example of converting array into hash-map
  ;; (http://stackoverflow.com/questions/4328709/convert-an-array-of-tuples-into-a-hash-map-in-clojure)	
  ;; reduce does the function provided to the provided elements ex. vector
  ;; https://clojuredocs.org/clojure.core/reduce
  (reduce
    (fn [m tupel]
      ;; (https://clojuredocs.org/clojure.core/assoc)
      (assoc m
             ;; key
             ;; get value from vector splited on whitespace
             ;; (http://clojure.github.io/clojure/clojure.core-api.html#clojure.core/get)
             ;; get the first element of newely gotten vector of 2 values -> key & value
             ;; (http://stackoverflow.com/questions/16623788/get-element-from-sequence-in-clojure)
             ;; #" " -> regular expresions
             ;; (https://clojuredocs.org/clojure.string/split)
             ;; get
             ;; (http://en.wikibooks.org/wiki/Clojure_Programming/Examples/API_Examples/Hash-map_tools)
             (get (clojure.string/split tupel #" ") 0)
             ;; value
             ;;  get the second element of newely gotten vector of 2 values -> key & value
             ;; (http://stackoverflow.com/questions/16623788/get-element-from-sequence-in-clojure)
             (get (clojure.string/split tupel #" ") 1)))
    ;; put key-value into map
    {}
    ;; vector with data from get-data-content
    data
  ))

#_(make-map (get-data-content))

(defn sort-map [map]
  (into (sorted-map) map)
  )

#_(sort-map (make-map (get-data-content)))