


(println "=== 1. LIST ===")
(def original-list '(10 20 30))
(println "Original list:        " original-list)
(println "first:                " (first original-list))
(println "rest:                 " (rest original-list))


(def new-list (conj original-list 5))
(println "After (conj list 5):  " new-list)
(println "Original unchanged?   " original-list) 



(println "\n=== 2. VECTOR ===")
(def original-vec [10 20 30])
(println "Original vector:      " original-vec)
(println "get index 1:          " (get original-vec 1))
(println "count:                " (count original-vec))


(def new-vec (conj original-vec 40))
(println "After (conj vec 40):  " new-vec)
(println "Original unchanged?   " original-vec) 



(println "\n=== 3. MAP ===")
(def original-map {:name "Alice" :age 20})
(println "Original map:         " original-map)
(println "get :name:            " (get original-map :name))


(def map-with-city (assoc original-map :city "Delhi"))
(println "After assoc :city:    " map-with-city)
(def map-without-age (dissoc original-map :age))
(println "After dissoc :age:    " map-without-age)
(println "Original unchanged?   " original-map) 



(println "\n=== 4. SET ===")
(def original-set #{1 2 3})
(println "Original set:         " original-set)
(println "contains? 2:          " (contains? original-set 2))
(println "contains? 5:          " (contains? original-set 5))


(def set-added (conj original-set 4))
(println "After (conj set 4):   " set-added)


(def set-removed (disj original-set 2))
(println "After (disj set 2):   " set-removed)
(println "Original unchanged?   " original-set) 
