


(println "Math/abs (-25):              " (Math/abs -25))
(println "Math/sqrt (16):              " (Math/sqrt 16))
(println "System/currentTimeMillis:    " (System/currentTimeMillis))


(println "\n Creating Java Object Instances ")

(def array-list (new java.util.ArrayList))
(println "Created ArrayList with (new java.util.ArrayList):" array-list)
(def hash-map (java.util.HashMap.))
(println "Created HashMap with (java.util.HashMap.):       " hash-map)



   
(.add array-list "Apple")
(.add array-list "Banana")
(.add array-list "Cherry")
(println "ArrayList after .add:        " array-list)
(println "Element at index 1 (.get 1): " (.get array-list 1))
(println "Size of ArrayList (.size):   " (.size array-list))

(.put hash-map "course" "Clojure")
(.put hash-map "credits" 4)
(println "HashMap after .put:          " hash-map)
(println "Get value for 'course' (.get):" (.get hash-map "course"))





(def clj-vec [10 20 30 40])
(def java-list-from-clj (java.util.ArrayList. clj-vec))
(println "Clojure Vector:              " clj-vec " (type:" (type clj-vec) ")")
(println "Converted to Java ArrayList: " java-list-from-clj " (type:" (type java-list-from-clj) ")")

(def clj-vec-from-java (vec array-list))
(println "Java ArrayList:              " array-list " (type:" (type array-list) ")")
(println "Converted to Clojure Vector: " clj-vec-from-java " (type:" (type clj-vec-from-java) ")")
