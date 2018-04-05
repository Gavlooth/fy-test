(ns overcell.accounts-queries
  (:require [hugsql.core :as hug]
            [clojure.java.jdbc :as j]
            [taoensso.timbre :as timbre]))


(def account-ops (hug/map-of-db-fns "db/accounts.sql"))
(def account-ops-sqlvecs (hug/map-of-sqlvec-fns "db/accounts.sql"))

;;================================FIRST PROPOSAL=======================================

(defn exec-query
  "ececut a quary writen in a  hugsql script with
   appropriate parameters."
  [conn-pool query-fn params]
  (j/with-db-connection [conn {:datasource conn-pool}]
    (timbre/info (query-sqlvec params))
    (query-fn conn params)))

(defn get-account
  [conn-pool email])

(defn create-account
  [conn-pool email encrypted-password])

(defn update-accounts
  [conn-pool {:keys []}]
  )


(defn create-accunt-from-fb
  [conn-pool {:keys []}]
  )

(defn merge-fb account
  [conn-pool {:keys []}] )

(defn delete-account
  "Delete one account according to test of where clause. Returns 1 on success, else 0."
  [conn-pool {:keys []}]
  )

(defn update-last-sign-in
  [conn-pool id ip]
  )

