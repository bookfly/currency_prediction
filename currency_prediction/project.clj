(let [nar-classifier (str (System/getProperty "os.arch") "-"
                          (System/getProperty "os.name") "-gpp-jni")]

(defproject currency_prediction "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring "1.3.2"]
                 [clj-http "1.0.1"]
                 [compojure "1.3.1"]
                 [clj-time "0.9.0"]
                 [uncomplicate/neanderthal "0.1.1"]
                 [uncomplicate/neanderthal-atlas "0.1.0" :classifier ~nar-classifier]
                 ]
 :plugins [[lein-ring "0.9.1"]
           [lein2-eclipse "2.0.0"]          
           [lein-localrepo "0.5.3"]]    
  ;; :ring {:handler cljs_basic.core/app}
  :profiles {:dev {:dependencies [[midje "1.6.3"]]}}
   )
)