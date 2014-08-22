(ns code-katas-1.core)

(defn filter-odd
  "Escribir una funcion que retorne solamente los numeros impares de
   una secuencia"
  [s]
  (filter odd? s)
  )

(defn nil-key
  "Escribir una funcion que dada una clave y un mapa, devuelva true, solamente si el mapa
   contiene una entrada con esa clave, y su valor es nil"
  [k m]
  (if (contains? m k)      ; si el mapa contiene la clave
    (if (nil? (get m k))   ; si la clave tiene valor nulo
      true                 ; devuelve true 
      false)               ; sino false
    false  )               ; sino contiene la clave devuelve false
  )

(defn range
  "Escribir una funcion que cree una lista de enteros en un rango dado.
   Restricciones: range"
  [start end]
  (def salida ())          ; se define una lista llamada salida
  (dotimes [repetir (- end start)]  ; bucle que repite (end - start) veces, repetir se va incrementando de a 1
    (def salida (cons (+ repetir start) salida))) ; se va redefiniendo la salida con la con la concatenacion de ella misma y (repetir + start)
  (def salida (sort salida)) ; se da vuelta la lista
  salida  )

(defn compress-sequence
  "Escribir una funcion que elimine los duplicados consecutivos
   de una secuencia"
  [s]
  (if (string? s)
    (when-let [[primero & resto] s]  ; se recorre la secuencia (si primero y resto no son nulos)
      (if (= primero (first resto))  ; si el primero es igual a el primero de la lista resto
        (compress-sequence resto)    ; se llama recursivamente a la función
        (apply str(cons primero (compress-sequence resto))))) ; concatena el primero y lo que devuelve la llamada recursiva de la función al resto (lista) y lo convierte en string
    (when-let [[primero & resto] s]  ;lo mismo que que el when-let anterior pero al final no lo convierte en string
      (if (= primero (first resto)) 
        (compress-sequence resto) 
        (cons primero (compress-sequence resto)))))
  )

(defn max-value
  "Escribir una funcion que reciba un numero variable de parametros
   y retorne el que tenga el valor mayor
   Restricciones: max y max-key"
  [& args])

(defn split-two
  "Escribir una funcion que parta una secuencia en dos partes
   Restricciones: split-at"
  [length s]
  (if (list? s)
    (into  (cons (drop length s) '()) (cons (take length s) '()) ) ; junta las listas formadas una de ellas desde el comienzo de la secuencia hasta length y la otra desde legth hasta el final 
    (if (vector? s)
      (into  (apply vector(cons (apply vector (take length s)) '[])) (apply vector(cons (apply vector (drop length s)) '[])) ) ; lo mismo pero transformando a vector
      nil))
  )

(defn inter-two
  "Escribir una funcion que reciba dos secuencias y retorne el primero de cada una,
   luego el segundo de cada una, luego el tercero, etc.
   Restricciones: interleave"
  [s1 s2]
  (mapcat vector s1 s2) ; intercala las secuencias con mapcat
  )

(defn retrieve-caps
  "Escribir una funcion que reciba un string y devuelva un nuevo string conteniendo
   solamente las mayusculas."
  [text]
  (apply str(filter  (fn[caracter](Character/isUpperCase caracter)) text)) ; filtra los caracteres que no son Mayus, quedando estos últimos y los convierte en string
  )

(defn find-truth
  "Escribir una funcion que tome un numero variable de booleans, y devuelva true
   solamente si alguno de los parametros son true, pero no todos son true. En otro
   caso debera retornar false"
  [& xs]
  (if (first (reverse (conj (filter false? xs) true))) ;si la lista obtenida al filtrar xs obteniendo solo los false y haciendo reverse, el primer elemento es true (osea que no tiene ningún false, son todos true en la secuencia)
    false 
    (if (first (reverse (conj (filter true? xs) false))) ; si ña lista obtenida al filtrar xs obteniendo solo los true y haciendo reverse, el primer elemento es true (osea hay algún true en la secuencia) 
      true
      false)   ; de lo contrario son todos false
    )
  )

(defn zip-map
  "Escribir una funcion que reciba un vector de claves y un vector de valores, y
   construya un mapa a partir de ellos.
   Restricciones: zipmap"
  [k v]
  )
