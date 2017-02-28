(ns tic-tac-toe.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn check-for-winner
  [board]
  (check-rows-for-winner board)
  (check-columns-for-winner board)
  (check-diagonal-for-winner board))

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
