(ns day3
  (:require [clojure.set :as set]
            [util]))

(defn split-into-compartments [rucksack]
  (let [middle-index (/ (count rucksack) 2)]
    [(take middle-index rucksack) (drop middle-index rucksack)]))

(defn- common-item [compartments]
  (apply set/intersection (map set compartments)))

(def priority
  (zipmap "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
          (range 1 53)))

(comment

  ;;part-2
  (->> (util/read-lines "input/day3.txt")
       (partition 3)
       (map common-item)
       (apply concat)
       (map priority)
       (apply +))
  
  (concat #{1 2} #{2 3} )
  (priority \z)

  (set "abc")

  ;;part-1
  (common-item "abcdefab")
  (->>
   (util/read-lines "input/day3.txt")
   (map split-into-compartments)
   (map common-item)
   (map first)
   (map priority)
   (apply +))

  (Character/isUpperCase \a)

  (int \a)
  (int \A)

  (set/intersection (set "abc") (set "bcd"))

  )