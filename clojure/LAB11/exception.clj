
(defn validate-age [age]
  (if (< age 18)
    (throw (ex-info "Access Denied: User is underage"
                    {:user-age age :required-age 18 :status :failed}))
    (str "Access granted for age: " age)))


(defn test-operation [label op]
  (println (str "\n--- " label " ---"))
  (try
    (let [result (op)]
      (println "Success: " result))
    
   
    (catch ArithmeticException e
      (println "Caught ArithmeticException: " (.getMessage e))
      (println "Graceful Recovery: Defaulting to 0"))
    

    (catch NullPointerException e
      (println "Caught NullPointerException: Method called on nil")
      (println "Graceful Recovery: Defaulting to \"Unknown\""))
    

    (catch clojure.lang.ExceptionInfo e
      (println "Caught Custom Exception (ex-info):")
      (println "  ex-message: " (ex-message e))
      (println "  ex-data:    " (ex-data e))
      (println "Graceful Recovery: Assigned guest account"))
    
    (finally
      (println "[finally] Cleanup / operation finished."))))




(test-operation "Test 1: Arithmetic Exception"
  (fn [] (/ 10 0)))


(test-operation "Test 2: Null Pointer Exception"
  (fn [] (let [^String s nil] (.length s))))


(test-operation "Test 3: Custom Exception (Underage)"
  (fn [] (validate-age 15)))


(test-operation "Test 4: Normal Valid Execution"
  (fn [] (validate-age 25)))
