(ns overcell.components.app-config
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [com.stuartsierra.component :as component]
            [taoensso.timbre :as timbre]
            [taoensso.timbre.appenders.core :as appenders]))


(defn- get-salt [{:keys [config excluded]}]
  (add-salt (-> "config.edn" slurp read-string :encryption-salt) ))

(defn- enable-logging [{:keys [config excluded]}]
  (timbre/merge-config! (-> "config.edn" slurp read-string :logging) ))

(defn- disable-logging []
  (timbre/merge-config! {:appenders {:spit nil}}))

(defrecord AppConfig [config-path]
  component/Lifecycle
  (start [component]
   (enable-logging) )
  (stop [component]
   (disable-logging)))

(defn app-config [config-path]
  (map->AppConfig {:config-path config-path}))
