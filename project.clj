(defproject antizer-demo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
                 ;; backend dependencies
                 [org.clojure/clojure "1.8.0"]
                 [http-kit "2.0.0"]
                 [compojure "1.6.0"]
                 [ring-server "0.5.0"]
                 [ring/ring-json "0.4.0"]

                 ;; frontend dependencies
                 [org.clojure/clojurescript "1.9.946"]
                 [reagent "0.8.0-alpha2"]
                 [antizer "0.2.2"]
                 [cljsjs/moment "2.17.1-1"]]
  :main antizer-demo.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :plugins [[lein-cljsbuild "1.1.7"]]
  :source-paths ["src", "src-cljs"]
  :cljsbuild {:builds [{:id "prod"
                        :source-paths ["src-cljs"]
                        :compiler {:output-to "resources/public/js/app-prod.js"
                                   ;; output-dir must be a subdir of the above when optimizations are enabled
                                   :output-dir "resources/public/js/out-prod"
                                   :optimizations :advanced
                                   :source-map "resources/public/js/app-prod.map"}}
                       ]}
  )
