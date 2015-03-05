(ns currency-prediction.approximation
  (:require [clj-time [format :as f]])
  (:require [clj-time.core :as time])     
  (:require [clj-time.coerce :as tc])
  )
  

;; Get milliseconds since Unix epoch
;; (http://stackoverflow.com/questions/17432032/how-do-i-get-a-unix-timestamp-in-clojure)
(defn get-mills-since-ue []
  (tc/to-long (time/now)))

#_(get-mills-since-ue)

;; Get difference between current and given date/time
#_(defn [date])

;; give string time
;; parse string time into date
;; (http://java.dzone.com/articles/clojure-converting-string-date)
;;(require '(clj-time [format :as f]))
;;(def string-date "18 September 2012")
;;(f/parse (f/formatter "dd MMM YYYY") string-date)
;;(f/show-formatters)

;;(parse (formatters :date) "2012-06-02")

;; Take a look at
;; http://stackoverflow.com/questions/14757553/how-to-convert-a-clojure-java-date-to-simpler-form



;; TODO
;; Get date from data
;; Count date into time (milisec etc?) -> get values for x axis
;;
;; Get value from data
;; Parse it into double -> get values for y axis
;;
;; Put it into map
