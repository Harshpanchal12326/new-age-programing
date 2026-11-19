

(defn square [x]
  (* x x))

(defn test-transformations [coll-name coll]
  (println (str "=== Testing on " coll-name ": " coll " ==="))
  
  (println "1. map (square):     " (map square coll))
  
  (println "2. filter (even?):   " (filter even? coll))
  
  (println "3. reduce (+ sum):   " (reduce + coll))
  (println "   reduce (max):     " (reduce max coll))
  
  (println "4. take 3:           " (take 3 coll))
  (println "   drop 2:           " (drop 2 coll))
  
  (def chained-result
    (->> coll
         (filter even?)
         (map square)
         (take 2)))
  (println "5. Threading (->>):  " chained-result)
  
  (println))

(test-transformations "Vector" [1 2 3 4 5 6])

(test-transformations "List" '(10 15 20 25 30))
