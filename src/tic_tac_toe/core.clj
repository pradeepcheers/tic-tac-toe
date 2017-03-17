(ns tic-tac-toe.core
  (:gen-class))

(require '[clojure.string :as s])

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn check-for-winner
  [board]
  (or 
   (check-rows-for-winner board) 
   (check-columns-for-winner board) 
   (check-diagonals-for-winner board)))

(defn check-rows-for-winner
  [board]
  (if (apply = (board 0))
    (get-in board [0 0])
    (if (apply = (board 1))
      (get-in board [1 1])
      (if (apply = (board 2))
        (get-in board [2 2])))))

(defn check-columns-for-winner
  [board]
  (check-rows-for-winner (apply mapv vector board)))

(defn check-diagonals-for-winner
  [board]
  (if (apply = [(get-in board [0 0]) (get-in board [1 1]) (get-in board [2 2])])
    (get-in board [1 1])
    (if (apply = [(get-in board [0 2]) (get-in board [1 1]) (get-in board [0 2])])
      (get-in board [1 1]))))

(defn display-board [b]
  (def bar  "--------------\n")
  (defn row-to-str [r]
    (str "| " (s/join " | " r) " |"))
  (println (str bar (s/join "\n" (map row-to-str b)) "\n" bar)))

(display-board sample-board)

(defn get-col [ b n]
  (map #(get % n) b))

(defn get-row [ b n]
  (get b n ))

(defn get-diag [ b dir]
  (mapv #(get %1 %2) b (range 3)))

(get-diag sample-board 1)

(get-col sample-board 2)

(get-row sample-board 2)

(def board (atom [["_" "_" "_"] ["_" "_" "_"] ["_" "_" "_"]]))

(get-in board [1 2])

(def player1 "X")
(def player2 "O")

(defn play
  [player [a b]]
  (if (= "_" (get-in @board [a b]))
    (reset! board (update-in @board [a b] #(clojure.string/replace % #"_" player)))
    "Invalid move!"))

(play player2 [0 0])
(play player1 [1 2])
(play player2 [0 1])
(play player1 [0 1])

