(ns tutorial-clojure.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [tutorial-clojure.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[tutorial-clojure started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[tutorial-clojure has shut down successfully]=-"))
   :middleware wrap-dev})
