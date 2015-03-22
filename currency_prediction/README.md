# currency_prediction

Getting started with Clojure - application for predicting currency

## Usage

**FIXME**

Application for predicting what will be the value of EUR (EU) in RSD (Serbia).

Based on the history of the currency change (from the beginning of 2012 till today) predict the value for tomorrow.

**TODO**

1. Data
  * Send request/get data (http://currencies.apps.grandtrunk.net/)
  * Unpack received data (get what is needed) -> put into sorted map
  * Test (function for making map giving expected hash-map)

2. Calculation
  * Process the data (parse double, calculate date)

3. Approximation
  * Put data into matrix
  * Process data


Bonus:
- Setting application for predicting any currency DONE
- Setting application for predicting currency for any date DONE


## License

Copyright © 2015 Jelena Tabas

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
