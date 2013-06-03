;(println (+ 1 2))

;(defn prepend-hello [names]
 ; (map (fn [name] (str "Hello, " name)) names))
;
;(println (prepend-hello ["Graham", "Chenai"]))


;(defn sum-sequence [s]
;  {:pre [(not (empty? s))]}
;  (reduce + s ))

;(println (sum-sequence [1 2 3 4 5 6 7 8]))

;(defn generate-model [file])

;(defn read-models [files]
;  (map generate-model files))

(use '[clojure.java.io])
 
(defn walk [dirpath pattern]
  (doall (filter
	  #(re-matches pattern (.getName %))
	  (file-seq (file dirpath)))))
 
(map #(println (.getPath %))
     (walk "src" #".*\.scala"))

;(println (walk "src" #".*\.scala"))

;;(println (file-seq (file ".")))