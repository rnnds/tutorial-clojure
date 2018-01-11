(ns user
  (:require [luminus-migrations.core :as migrations]
            [tutorial-clojure.config :refer [env]]
            [mount.core :as mount]
            tutorial-clojure.core))

(defn start []
  (mount/start-without #'tutorial-clojure.core/repl-server))

(defn stop []
  (mount/stop-except #'tutorial-clojure.core/repl-server))

(defn restart []
  (stop)
  (start))

(defn migrate []
  (migrations/migrate ["migrate"] (select-keys env [:database-url])))

(defn rollback []
  (migrations/migrate ["rollback"] (select-keys env [:database-url])))

(defn create-migration [name]
  (migrations/create name (select-keys env [:database-url])))


