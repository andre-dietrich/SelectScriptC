(ns selectscript.defines)

(defn ss:val [val]
  (list :val val))

(defn ss:var [var]
  (list :var var))


(defn ss:op [op params]
  (list :op op params))

(defn ss:opX [op params]
  (list :opX op params))

(defn ss:list [elements]
  (list :list elements))

(defn ss:exit [expr]
  (list :exit expr))

(defn ss:try [try catch]
  (list :try try catch))

(defn ss:loc [loc extra]
  (list :loc loc extra))

(defn ss:proc [params code info]
  (list :proc params code info))

(defn ss:if [if then else]
  (list :if if then else))

(defn ss:elem [var elems]
  (list :elem var elems))

(defn ss:set [elements]
  (list :set (distinct elements)))

(defn ss:fct [fct params]
  (list :fct fct params))

(defn ss:loop [elements]
  (list :loop elements))

(defn ss:dict [elements]
  (list :dict (into {} elements)))

(defn ss:val? [op & ops]
  (if (not (.contains '(:val :list :set :dict) (first op)))
    false
    (if (empty? ops)
      true
      (recur (first ops) (rest ops)))))

(defn ss:valX? [op & ops]
  (if (not (.contains '(:val) (first op)))
    false
    (if (empty? ops)
      true
      (recur (first ops) (rest ops)))))


(defn ss:bool? [val]
  (if (number? val)
    (not (zero? val))
    (if (or (string? val)
            (list?   val)
            (map?    val))
      (not  (empty? val))
      val)))

(defn ss:and [p1 p2]
  (let [p [(ss:bool? p1) (ss:bool? p2)]]
    (case p
      [nil   nil  ] nil
      [false nil  ] false
      [nil   false] false
      [nil   true ] nil
      [true  nil  ] nil
      (and (p 0) (p 1)))))


(defn ss:or [p1 p2]
  (let [p [(ss:bool? p1) (ss:bool? p2)]]
    (case p
      [nil   nil  ] nil
      [false nil  ] nil
      [nil   false] nil
      [nil   true ] true
      [true  nil  ] true
      (or (p 0) (p 1)))))


(defn ss:xor [p1 p2]
  (let [p [(ss:bool? p1) (ss:bool? p2)]]
    (case p
      [true  true ] false
      [true  false] true
      [false true ] true
      [false false] false
      nil)))

(defn ss:add [p1 p2]
  (+ p1 p2))

(defn ss:sub [p1 p2]
  (- p1 p2))

(defn ss:mul [p1 p2]
  (* p1 p2))

(defn ss:div [p1 p2]
  (/ p1 p2))

(defn ss:mod [p1 p2]
  (mod p1 p2))

(defn ss:pow [p1 p2]
  (let [x (Math/pow p1 p2)]
    (if (or (float? p1)
            (float? p2))
      x
      (int x))))

(defn ss:not [p]
  (if (nil? p)
    nil
    (not (ss:bool? p))))

(defn bool? [x]
  (or (true? x) (false? x)))

(defn ss:num [x]
  (if (false? x)
    0
    (if (true? x)
      1
      x)))


(defn ss:lt [p1 p2]
  (try
    (if (< (compare (ss:num p1) (ss:num p2)) 0)
      p2
      :false)
    (catch Exception e :nil)))

(defn ss:le [p1 p2]
  (try
    (if (<= (compare (ss:num p1) (ss:num p2)) 0)
      p2
      :false)
    (catch Exception e :nil)))

(defn ss:gt [p1 p2]
  (try
    (if (> (compare (ss:num p1) (ss:num p2)) 0)
      p2
      :false)
    (catch Exception e :nil)))


(defn ss:ge [p1 p2]
  (try
    (if (>= (compare (ss:num p1) (ss:num p2)) 0)
      p2
      :false)
    (catch Exception e :nil)))

(defn ss:eq [p1 p2]
  (if (= p1 p2)
    p2
    :false))

(defn ss:iand [p1 p2]
  (bit-and (ss:num p1)
           (ss:num p2)))

(defn ss:ior [p1 p2]
  (bit-or (ss:num p1)
          (ss:num p2)))

(defn ss:ixor [p1 p2]
  (bit-xor (ss:num p1)
           (ss:num p2)))

(defn ss:inot [p]
  (bit-not (ss:num p)))

(defn ss:left [p1 p2]
  (bit-shift-left (ss:num p1)
                  (ss:num p2)))

(defn ss:right [p1 p2]
  (bit-shift-right (ss:num p1)
                   (ss:num p2)))
