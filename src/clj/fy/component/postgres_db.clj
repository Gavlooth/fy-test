(ns overcell.components.postgres-db
  (:require [com.stuartsierra.component :as component]
            [taoensso.timbre :as timbre]
            [hikari-cp.core :refer :all]))

(defrecord PostgresDB [app-config]
  component/Lifecycle
  (start [component]
    (if (:conn component)
      component
      (let [datasource-options (get-in app-config [:options :db-conn-config])
            datasource         (make-datasource datasource-options)]
        (timbre/info "[PostgresDB] Connection pool started with configuration: " datasource-options)
        (timbre/info "[PostgresDB] Using db: " (:database-name datasource-options))
        (assoc component :conn datasource))))
  (stop [component]
    (if-let [conn (:conn component)]
      (do
        (close-datasource conn)
        (timbre/info "[PostgresDB] Connection pool stopped")
        (assoc component :conn nil))
      component)))

(defn postgres-db []
  (map->PostgresDB {}))
