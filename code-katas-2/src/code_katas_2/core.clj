(ns code-katas-2.core)


(defn unpartial
  "Escribir una funcion que acepte una funcion parcial con cantidad de argumentos desconocida,
   retornar una funcion equivalente de n argumentos"
  [f]
  (partial (fn [f & args]                ; función parcial fn con argumento precargado f, luego los argumentos se pueden pasar hacieno ((unpartial función ) argumentos)
           (let [resultado (f (first args))]  ; "resultado" es el resultado de aplicar f al primer argumento.
             (if (fn? resultado)              ; si es una función
               (recur resultado (rest args))  ; se sigue con el resto de los argumentos
               resultado)))                   ; sino devuelve "resultado"
         f)
  )


(defn search
  "Dado un numero cualquiera de secuencias, cada una ya ordenada de menor a mayor, encontrar el numero
   mas chico que aparezca en todas las secuencias, las secuencias pueden ser infinitas."
  [& seqs]
  (if (= (count (set (map first seqs))) 1)  ; si la cantidad de elementos del seteo de la secuencia obtenida al aplicar map de first (osea obtener todos los primeros elementos de cada secuencia) es igual a 1.
    (first (sort (map first seqs)))         ; se devuelve el primer elemento de ordenar de menor a mayor la secuencia obtenida al aplicar map de first (osea obtener todos los primeros elementos de cada secuencia)
    (apply search (map (fn [a]              ; se llama recursivamente a search con el resultado de map de la función
                       (if (= (first a) (first (sort (map first seqs)))) ; la función verifica para una secuencia dada, si su primer elemento es igual al primero de la secuencia de primeros ordenada de seqs.
                         (rest a)            ; devuelve resto de la secuencia (osea sin el primero)
                         a))                 ; sino devuelve toda la secuencia.
                       seqs)))
 )


(defn intercalar
  "Escriba una funcion que tome un predicado de 2 argumentos, un valor y una coleccion, y
   retorne una nueva coleccion donde el valor es insertado intercalado cada dos argumentos
   que cumplan el predicado"
  [predicado valor secuencia]
  (lazy-seq (if (or (= (count secuencia) 0) (= (count secuencia) 1)) ; si la secuencia tiene un elemento o ninguno devuelve la secuencia misma
              secuencia
              (if (predicado (first secuencia) (second secuencia))   ; sino, verifica si los dos primeros elementos de la secuencia cumplean el predicado   
                (concat (list (first secuencia) valor) (intercalar predicado valor (rest secuencia))) ;concatena  el primer elemento con su valor con la llamada recursiva a intercalar pero con el resto de la secuencia
                (conj (intercalar predicado valor (rest secuencia)) (first secuencia)) ;sino agrega el primer elemento al comienzo seguido por la llamada recursiva a intercalar pero con el resto de la secuencia
                )
              )
            )   
  )
  


(defn tartamudeo
  "Escriba una funcion que retorne una secuencia lazy que comprima el tartamudeo de una secuencia de numeros.
   Comprimir el tartamudeo se refiere a que [1 1 1] se exprese como [3 1] y a su vez [3 1] se exprese como [1 3 1 1].

   La funcion debe aceptar una secuencia inicial de numeros, y devolver una secuencia infinita de compresiones, donde
   cada nuevo elemento es el elemento anterior comprimido."
  [secuencia]
  
  (defn auxiliar [veces seq] 
    (when-let [[primero & resto] seq]  
      (if (= primero (first resto)) 
        (auxiliar (inc veces) resto) 
        (apply vector (concat (list veces) (concat (list primero) (auxiliar 1 resto))))))) 
  
  (rest (iterate (partial auxiliar 1) secuencia))
  )
