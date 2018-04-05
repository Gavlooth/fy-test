(ns fy.component.web-server)



(defrecord WebServer [app-config app-handler]
  component/Lifecycle
  (start [component])
  (stop [component]))
