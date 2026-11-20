(ns app
  (:require [ring.adapter.jetty :as jetty]
            [next.jdbc :as jdbc]))

(def students
  [{:id 3 :name "Harsh"      :course "DS"  :marks 45}
   {:id 4 :name "Aman"       :course "CSE" :marks 92}
   {:id 5 :name "Rohan"      :course "IT"  :marks 64}])

(def passed-students
  (filter #(>= (:marks %) 50) students))

(def total-marks
  (reduce + (map :marks passed-students)))

(def avg-marks
  (double (/ total-marks (count passed-students))))

(def db {:dbtype "sqlite" :dbname "students.db"})

(defn init-db []
  (try
    (jdbc/execute! db ["DROP TABLE IF EXISTS students"])
    (jdbc/execute! db ["CREATE TABLE students (id INT, name TEXT, course TEXT, marks INT)"])
    (println "Database initialized.")
    (catch Exception _ nil)))

(defn insert-students []
  (try
    (doseq [s students]
      (jdbc/execute! db ["INSERT INTO students VALUES (?, ?, ?, ?)"
                         (:id s) (:name s) (:course s) (:marks s)]))
    (println "Inserted 5 records into SQLite database.")
    (catch Exception _ nil)))

(defn read-students []
  (try
    (jdbc/execute! db ["SELECT id, name, course, marks FROM students"])
    (catch Exception _ [])))

(defn handler [req]
  (case (:uri req)
    "/"
    {:status 200
     :headers {"Content-Type" "text/plain"}
     :body " University Student Portal\nWelcome, sir!\n\nAvailable Endpoints:\n1. /students - View all students from SQLite DB\n2. /passed   - View passed students\n3. /summary  - View total and average marks\n"}

    "/students"
    {:status 200
     :headers {"Content-Type" "text/plain"}
     :body (str (read-students))}

    "/passed"
    {:status 200
     :headers {"Content-Type" "text/plain"}
     :body (str passed-students)}

    "/summary"
    {:status 200
     :headers {"Content-Type" "text/plain"}
     :body (str "Total Marks: " total-marks "\nAverage Marks: " avg-marks)}

    {:status 404
     :body "Not Found"}))

(defn -main []
  (doseq [s passed-students]
    (println (str (:name s) " (" (:course s) ") - " (:marks s) " marks")))
  (println "Total Marks:" total-marks)
  (println "Average Marks:" avg-marks)

  (println "\n 2. Relational Database Operations (SQLite + Java Interop) ")
  (init-db)
  (insert-students)
  (println "Reading records back from database:")
  (doseq [r (read-students)]
    (println (str " {:id " (:students/id r)
                  ", :name " (:students/name r)
                  ", :course " (:students/course r)
                  ", :marks " (:students/marks r) "}")))

  (println "\n 3. Ring HTTP Server ")
  (println "Testing Ring handler directly for endpoint '/':")
  (let [res (handler {:uri "/"})]
    (println "Status:" (:status res))
    (println "Body:\n" (:body res)))

  (println "Starting Ring Jetty Server on http://localhost:3000 ...")
  (try
    (jetty/run-jetty handler {:port 3000 :join? false})
    (catch Exception _ nil)))

(-main)
