(ns tutorial-clojure.routes.home
  (:require [tutorial-clojure.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [tutorial-clojure.db.core :as db]
            ))

(defn home-page []
  (layout/render
    "home.html" {
      :docs (-> "docs/docs.md" io/resource slurp)
      :users (db/get-all-users)
      }))

(defn about-page []
  (layout/render "about.html"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page)))

