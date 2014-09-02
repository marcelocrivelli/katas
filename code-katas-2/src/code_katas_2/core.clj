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
  (first (reduce                        ; toma el primer elemento del resultado de aplicar la funcion al primer elemento, que como es solo un parametro devuelve este mismo
           (fn ([a] a)                  ; luego aplica la funcion al segundo con lo que retorno de la llamada del primero y asi sucesivamente hasta obtener la intersección de todas las secuencias.
             ([a b] 
               (filter (set a) b)))     ; setea la secuencia a y para cada valor de esta filtra la secuencia b, quedando asi la intersección de las secuencias pero sin valores repetidos ya que el set los transforma en valores no iguales a ninguno de ellos.
           seqs))
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
  )
