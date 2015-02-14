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
;; get first string and split it at blankspace,
;; make hash-map and put
;; first part as key (date)
;; second as value (decimal number)
(defn make-map [map-provided]
  ;;v put into map
  ;; (https://clojuredocs.org/clojure.core/assoc)
  (assoc map-provided
         ;;key
         ;; missing the first string from vector
         ;; get value from vector splited on whitespace (get map key)
         ;; http://clojure.github.io/clojure/clojure.core-api.html#clojure.core/get
         (get (clojure.string/split get-data-content #" "))
         ;; value
         ()))

(make-map (get-data-content))

;; #" " -> regular expresions
;; (https://clojuredocs.org/clojure.string/split)
;; get
;; (http://en.wikibooks.org/wiki/Clojure_Programming/Examples/API_Examples/Hash-map_tools)
(defn create-map []
  
  (reduce (fn [m tupel] 
            (assoc m 
                   (aget tupel 0) 
                   (aget tupel 1))) 
  {} 
  array-of-tupels) 
  
)


;;TODO
;; Received data put into map
;; key is the date
;; value is the value


