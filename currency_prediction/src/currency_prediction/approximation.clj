(ns currency-prediction.approximation
  (:require [clj-time [format :as f]])
  (:require [clj-time.core :as time])     
  (:require [clj-time.coerce :as tc])
  )
  

;; Get milliseconds since Unix epoch until today
;; (http://stackoverflow.com/questions/17432032/how-do-i-get-a-unix-timestamp-in-clojure)
(defn get-mills-since-ue []
  (tc/to-long (time/now)))

#_(get-mills-since-ue)


;; Get milliseconds since Unix epoch until the date provided
;; (https://github.com/clj-time/clj-time)
(defn get-mills-until-date [date]
  (tc/to-long date))

#_(get-mills-until-date "2012-06-02")


;; Get difference between current and given date/time
(defn get-difference [date]
  (- (get-mills-since-ue) (get-mills-until-date date)))

#_(get-difference "2012-06-02")


;; Look at: http://stackoverflow.com/questions/10752659/how-to-convert-a-numeric-string-to-number-decimal-and-number-to-string
;; Parse given string into double
(defn parse-double [number]
  (Double/parseDouble (number)))

(parse-double read-string("3245.23"))

(defn String->Number [str]
  (let [n (read-string str)]
       (if (number? n) n nil)))

 (String->Number "4.5")
 
 (str 4.5)


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
