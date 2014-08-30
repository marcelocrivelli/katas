(ns code-katas-2.core)


(defn unpartial
  "Escribir una funcion que acepte una funcion parcial con cantidad de argumentos desconocida,
   retornar una funcion equivalente de n argumentos"
  [f]
  )


(defn search
  "Dado un numero cualquiera de secuencias, cada una ya ordenada de menor a mayor, encontrar el numero
   mas chico que aparezca en todas las secuencias, las secuencias pueden ser infinitas."
  [& seqs]
  ;(take 1(reduce (fn [a b] (filter (set a) b)) seq)) 
  ;(clojure.set/intersection seqs)
  ;(take 1 (lazy-seq (reduce clojure.set/intersection seq)))
  ;(if (not (empty? (rest seqs)))
  ; (filter (set (first seqs)) (set (search(rest seqs))))
  ; (first seqs)
  ; )
  ;(when-let [[primero & resto] seqs]
  ; (filter (set primero) (search resto)))
  (first (reduce (fn ([a] a) ([a b] (filter (set a) (set b)))) seqs))
  )


(defn intercalar
  "Escriba una funcion que tome un predicado de 2 argumentos, un valor y una coleccion, y
   retorne una nueva coleccion donde el valor es insertado intercalado cada dos argumentos
   que cumplan el predicado"
  [predicado valor secuencia]
  )


(defn tartamudeo
  "Escriba una funcion que retorne una secuencia lazy que comprima el tartamudeo de una secuencia de numeros.
   Comprimir el tartamudeo se refiere a que [1 1 1] se exprese como [3 1] y a su vez [3 1] se exprese como [1 3 1 1].

   La funcion debe aceptar una secuencia inicial de numeros, y devolver una secuencia infinita de compresiones, donde
   cada nuevo elemento es el elemento anterior comprimido."
  [secuencia]
  )
