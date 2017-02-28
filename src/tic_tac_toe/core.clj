(ns tic-tac-toe.core
  (:gen-class))

(require '[clojure.string :as s])


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


(def sample-board [
            [\X \- \O]
            [\- \- \X]
            [\- \- \O]
            ])



(defn display-board [b]
  (def bar  "--------------\n")
  (defn row-to-str [r]
    (str "| " (s/join " | " r) " |")
    )
  (println (str bar (s/join "\n" (map row-to-str b)) "\n" bar))  
  )

(display-board sample-board)


