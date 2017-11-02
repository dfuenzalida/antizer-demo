(ns antizer-examples.app
  (:require [antizer-examples.reagent :as reagent]
            [cljsjs.moment]))

;; (defn init! []
;;   (case js/example
;;     "reagent" (reagent/init!)
;;     "rum" (rum/init!)))

(enable-console-print!)
(reagent/init!)
