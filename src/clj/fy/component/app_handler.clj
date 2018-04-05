(ns overcell.components.app-handler)

(defn make-handler [& services]
  (-> roots
      (wrap-authentication session-auth)
      wrap-flash
      logger/wrap-with-logger
      wrap-env-middlewares))

(defrecord AppHandler [app-config]
  component/Lifecycle
  (start [component])
  (stop [component]))

(defn app-handler []
  (map->AppHandler {}))
