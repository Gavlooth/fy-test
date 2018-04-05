(ns fy.core
  (:gen-class))

(defn -main
(defn -main [& args]
  (let [prod-system
        (component/system-map
          :app-config (app-config "config.edn")
          :postgres-db (component/using
                         (postgres-db [:app-config]))
          :app-handler (component/using
                        (app-handler) [:app-config])
          :web-server (component/using
                        (web-server)
                        [:app-config :app-handler]))]
   (component/start prod-system))))
