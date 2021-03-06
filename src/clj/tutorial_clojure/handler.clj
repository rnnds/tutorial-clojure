(ns tutorial-clojure.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [tutorial-clojure.layout :refer [error-page]]
            [tutorial-clojure.routes.home :refer [home-routes]]
            [compojure.route :as route]
            [tutorial-clojure.env :refer [defaults]]
            [mount.core :as mount]
            [tutorial-clojure.middleware :as middleware]))

(mount/defstate init-app
  :start ((or (:init defaults) identity))
  :stop  ((or (:stop defaults) identity)))

(mount/defstate app
  :start
  (middleware/wrap-base
    (routes
      (-> #'home-routes
          (wrap-routes middleware/wrap-csrf)
          (wrap-routes middleware/wrap-formats))
      (route/not-found
        (:body
          (error-page {:status 404
                       :title "page not found"}))))))
