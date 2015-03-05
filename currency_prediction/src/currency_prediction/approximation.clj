(ns currency-prediction.approximation
  (:require [clj-time [format :as f]])
  (:require [clj-time.core :as time])     
  (:require [clj-time.coerce :as tc])
  )
  

;; Get milliseconds since Unix epoch until today
;; (http://stackoverflow.com/questions/17432032/how-do-i-get-a-unix-timestamp-in-clojure)
(defn get-mills-since-ue []
  (tc/to-long (time/now)))

;; Get date of the start of Unic epoch
(defn get-epoch-date []
   (time/epoch))

#_(get-mills-since-ue)
#_(get-epoch-date)


;; Get milliseconds since Unix epoch until the date provided
;; (https://github.com/clj-time/clj-time)
(defn get-mills-until-date [date]
  (tc/to-long date))

;; Parse string into date
(defn get-date-of-string [date]
  (tc/to-date date))

#_(get-mills-until-date "2012-06-02")
#_(get-date-of-date "2012-06-02")


;; Get difference between current and given date/time
(defn get-difference [date]
  (- (get-mills-since-ue) (get-mills-until-date date)))

;; Get difference between two dates [STILL NOT WORKING!!!]
(defn get-difference-date [date]
  (time/interval  (time/date-time (get-epoch-date)) (time/date-time (get-date-of-string date))))

#_(get-difference "2012-06-02")

(get-difference-date "2012 06 02")


;; Look at: http://stackoverflow.com/questions/10752659/how-to-convert-a-numeric-string-to-number-decimal-and-number-to-string
;; Parse given string into double
(defn parse-double [number]
  (read-string number))

#_(parse-double "3245.23")





;; Parse date to miliseconds - NOT USING!
#_(defn parse-date-to-mills [date]
   (tc/to-long date))


;; TODO
;; Get date from data
;; Count date into time (milisec etc?) -> get values for x axis
;;
;; Get value from data
;; Parse it into double -> get values for y axis
;;
;; Put it into map
