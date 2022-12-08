(ns day2
  (:require [util]
            [clojure.string :as str]))

(def symbol-to-shape
  {"A" :rock, "B" :paper, "C" :scissor,
   "X" :rock, "Y" :paper, "Z" :scissor})

(def points-for-shape
  {"X" 1, "Y" 2, "Z" 3})

(defn winning-condition [opponent me]
  (or (and (= me :rock)    (= opponent :scissor))
      (and (= me :paper)   (= opponent :rock))
      (and (= me :scissor) (= opponent :paper))))

(defn outcome-of-the-round [opponent me]
  (let [me (symbol-to-shape me)
        opponent (symbol-to-shape opponent)]
    (cond
      (= me opponent) 3
      (winning-condition opponent me) 6
      :else 0)))

(defn score [[opponent me]]
  (+ (points-for-shape me)
     (outcome-of-the-round opponent me)))

(defn parse [lines]
  (map #(str/split % #"\s") lines))

(defn part1 [file-name]
  (->> (util/read-lines file-name)
       parse
       (map score)
       (apply +)))

(comment
  (part1 "input/day2.txt")
  (score ["C" "Z"])
  (outcome-of-the-round "A" "Y")

  (points-for-shape "Z")

  (str/split "s y" #"\s")

  (parse
   (util/read-lines "example/day2.txt"))

  (->> (util/read-lines "example/day2.txt")
       parse
       (map score)))