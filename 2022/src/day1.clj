(ns day1
  (:require [util]))

(defn total-calory [calories]
  (->> calories
       (map read-string)
       (apply +)))

(defn part1 [input-file]
  (->> (util/read-lines input-file)
       (partition-by empty?)
       (remove #(= '("") %))
       (map total-calory)
       (apply max)))

(comment
  (part1 "input/day1.txt")
  
  (defn total-calory [calories]
    (->> calories
         (map read-string)
         (apply +)))
  
  (->> (util/read-lines "example/day1.txt")
       (partition-by empty?)
       (remove #(= '("") %))
       (map total-calory)
       (apply max))

  (partition-by empty?
                (util/read-lines "example/day1.txt"))
  )