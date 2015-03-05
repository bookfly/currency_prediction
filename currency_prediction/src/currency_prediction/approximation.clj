(ns currency-prediction.approximation
  (:require [currency-prediction.data :as data])
  (:require [clj-time [format :as f]])
  (:require [clj-time.core :as time])     
  (:require [clj-time.coerce :as tc]))
  
;; Get date of the start of Unic epoch
(defn get-epoch-date []
   (time/epoch))

#_(get-epoch-date)



;; Parse string into date
(defn get-date-of-string [date]
  (tc/to-date date))

;; Getting DateTime date from provided string
(defn get-date-of-date [date]
  (tc/from-date (get-date-of-string date)))

#_(get-date-of-string "2012-06-02")
#_(get-date-of-date "2012-06-02")



;; Get interval in days between two dates
(defn get-difference-date [date]
  (time/in-days (time/interval  (get-epoch-date)  (get-date-of-date date))))

#_(get-difference-date "2014-03-05")



;; Parse given string into double
;; (http://stackoverflow.com/questions/10752659/how-to-convert-a-numeric-string-to-number-decimal-and-number-to-string)
(defn parse-double [number]
  (read-string number))

#_(parse-double "3245.23")


;; Get hashMap from currency-prediction.data
;; Parse values - dates and doubles
;; Return into new hashMap




;; TODO
;; Get date from data
;; Count date into time (milisec etc?) -> get values for x axis
;;
;; Get value from data
;; Parse it into double -> get values for y axis
;;
;; Put it into map
