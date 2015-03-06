(ns currency-prediction.approximation
  (:require [currency-prediction.data :as data])
  (:require [clj-time.core :as time])     
  (:require [clj-time.coerce :as tc])
  )
  
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
(defn get-map []
  (data/sort-map (data/make-map (data/get-data-content))))

(get-map)



;; (http://stackoverflow.com/questions/8536644/looping-over-vectors)
(defn parse-map [map]
  (for [x map 
    ;; In x there are key and value assigned to it
    ;; Get key and parse it
    ;; Get value and parse it
    ;; Returne parsed values into map    
		    :let  [y (get-difference-date (key x))]
		    :let  [z (parse-double(val x))]]    
   [y z]))

#_(parse-map (get-map))

;; Count the number of elements in sequence
(count (parse-map (get-map)))






;; TODO
;; Take first 3 elements of sequence
;; Put them in equation
;; Equalize with 4th element of sequence
;; Do this for first 84 elements (3+1)
;; Last three elements should give the 88th element that is not there

;; Println members of the map
(map println (parse-map (get-map)))


;; Take element from sequence at given position
(defn iterate-sequence [seq position]
  (nth seq position))

;; Call iterate-sequence
(defn iteration [position]  
  (iterate-sequence (parse-map (get-map)) position)
  )

(iteration 0)

;; 
(defn take-elements 
  ([start]
    (iteration (- start 1))  
  )
  ([start end] 
   (if (< start end)
     (do
       (iteration (- start 1)) 
       (take-elements (+ start 1) end)
     )
     (take-elements end))))

(take-elements 1 3)
(take-elements 1)


;; iterator i koji ide od 0 do 3 
;; uzima 0, 1 i 2 i stavlja u prvu matricu
;; uzima 3 i stavlja u drugu matricu

;; i=0; i++; i<3
;; if i<>3
;; stavi u matricu A
;; if i==3
;; stavi u matricu y
















