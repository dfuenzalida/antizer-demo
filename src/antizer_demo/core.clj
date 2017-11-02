(ns antizer-demo.core
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.reload :as reload]
            [ring.util.response :as response])
  (:use [ring.middleware.json :only [wrap-json-response wrap-json-body]]
        [ring.middleware.params :only [wrap-params]]
        [ring.middleware.resource :only [wrap-resource]]
        [ring.middleware.session :only [wrap-session]]
        [org.httpkit.server :only [run-server]])
  (:gen-class))

(defroutes ring-app

  (GET "/" request
       {:status 200
        :body (slurp "resources/public/index.html")})

  (GET "/dummy.json" request
       {:status 200
        :body {:foo "bar" :timestamp (java.util.Date.)}}))

(def app (-> ring-app
             (wrap-resource "public") ;; serve from "resources/public"
             (wrap-resource "")
             (wrap-json-body {:keywords? true})
             wrap-json-response
             wrap-params
             handler/site))

;; HTTP-Kit based

(defn in-dev? []
  true)

(defn -main [& args] ;; entry point, lein run will pick up and start from here
  (let [handler (if (in-dev?)
                  (reload/wrap-reload app) ;; only reload when dev
                  app)]
    (println "Running server on port 3000...")
    (run-server app {:port 3000})))
