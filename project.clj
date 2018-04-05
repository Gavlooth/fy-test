(defproject fy "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [ ;;clojure & clojurescript
                 [org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.238"]
                 [org.clojure/core.async "0.4.474"]
                 [camel-snake-kebab "0.4.0"]
                 ;;json support for fb api
                 [cheshire "5.8.0"]
                 [cljs-ajax "0.7.3"]
                 ;;Dependency injection
                 [com.stuartsierra/component "0.3.2"]
                 [com.taoensso/timbre "4.10.0"]
                 [compojure "1.6.0"]
                 [hiccup "1.0.5"]
                 [ring-logger-timbre "0.7.6"]
                 [ring-middleware-format "0.7.2"]
                 [reagent "0.8.0-alpha2"]
                 [re-frame "0.10.5"]
                 [ring/ring-core "1.6.3"]
                 [ring/ring-defaults "0.3.1"]
                 [ring/ring-jetty-adapter "1.6.3"]
                 ;; [rum "0.10.8"] Personaly I prefer rum over reagent :)
                 [org.clojure/java.jdbc "0.7.5"]
                 [org.postgresql/postgresql "42.2.2"]
                 ;; migratus for database migrations
                 [migratus "1.0.6"]
                 [yesql "0.5.3"]
                 [hikari-cp "2.2.0"]
                 [com.layerware/hugsql "0.4.8"]
                 ;;authorization/authentication (season based, for starters)
                 [buddy/buddy-auth "2.1.0"]
                 [buddy/buddy-hashers "1.3.0"]
                 ;; Yet no decent sendgrid library for clojure
                 [com.sendgrid/sendgrid-java "4.1.2"]
                 [com.fzakaria/slf4j-timbre "0.3.8"]]


  :plugins [[lein-cljsbuild "1.1.6" :exclusions [[org.clojure/clojure]]]]


  :source-paths ["src/clj" "src/cljs"]

  :main ^:skip-aot fy.core
  :target-path "target/%s"
  :profiles {:uberjar
             {:source-paths ["env/prod"]
              :prep-tasks ["compile" ["cljsbuild" "once" "prod"]]
              :aot :all
              :uberjar-name "fy.jar"
              :cljsbuild
              {:builds [{:id "prod"
                         :source-paths ["src/cljs"]
                         :compiler {:main fy.core
                                    :output-to "resources/public/cljs/compiled/fy.js"
                                    :closure-defines {"goog.DEBUG" false}
                                    :source-map-timestamp true
                                    :optimizations :advanced
                                    :pretty-print false
                                   ; :externs ["some-externl.js"]
                                    }}]}}
             :dev
             {:dependencies [[binaryage/devtools "0.9.9"]
                             [com.cemerick/piggieback "0.2.2"]
                             [com.google.guava/guava "23.0"] ; 1.9.562 cljs still requires this, might also need it in production
                             [com.stuartsierra/component.repl "0.2.0"]
                             [figwheel-sidecar "0.5.15"]
                             [org.clojure/tools.namespace "0.2.11"]
                             [ring/ring-devel "1.6.3"]
                             [ring/ring-mock "0.3.2"]]
              :plugins [[lein-figwheel "0.5.10"]]
              :source-paths ["env/dev"]
              :repl-options {:init-ns user
                             :init (go)}
              :figwheel {:css-dirs ["resources/public/css"]
                         :server-logfile "log/figwheel.log"}
              :cljsbuild
              {:builds
               [{:id "dev"
                 :source-paths ["src/cljs"]
                 :figwheel true
                 :compiler {:main overcell.core
                            :asset-path "cljs/compiled/out"
                            :output-to "resources/public/cljs/compiled/fy.js"
                            :output-dir "resources/public/cljs/compiled/out"
                            :optimizations :none
                            :source-map-timestamp true
                            :preloads [devtools.preload]
                            :external-config
                            {:devtools/config
                             {:features-to-install
                              [:formatters :hints]
                              :print-config-overrides true}}}}]}}})
