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
  (if (contains? m k)
    (if (nil? (get m k))
      true
      false)
    false  )
  )

(defn range
  "Escribir una funcion que cree una lista de enteros en un rango dado.
   Restricciones: range"
  [start end]
  (def salida ())
  (dotimes [repetir (- end start)](def salida (cons (+ repetir start) salida)))
  (def salida (sort salida))
  salida  )

(defn compress-sequence
  "Escribir una funcion que elimine los duplicados consecutivos
   de una secuencia"
  [s]
  (if (string? s)
    (when-let [[primero & resto] s] 
      (if (= primero (first resto)) 
        (compress-sequence resto) 
        (apply str(cons primero (compress-sequence resto)))))
    (when-let [[primero & resto] s] 
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
    (into  (cons (drop length s) '()) (cons (take length s) '()) )
    (if (vector? s)
      (into  (apply vector(cons (apply vector (take length s)) '[])) (apply vector(cons (apply vector (drop length s)) '[])) )
      nil))
  )

(defn inter-two
  "Escribir una funcion que reciba dos secuencias y retorne el primero de cada una,
   luego el segundo de cada una, luego el tercero, etc.
   Restricciones: interleave"
  [s1 s2]
  (mapcat vector s1 s2) 
  )

(defn retrieve-caps
  "Escribir una funcion que reciba un string y devuelva un nuevo string conteniendo
   solamente las mayusculas."
  [text]
  (apply str(filter  (fn[caracter](Character/isUpperCase caracter)) text))
  )

(defn find-truth
  "Escribir una funcion que tome un numero variable de booleans, y devuelva true
   solamente si alguno de los parametros son true, pero no todos son true. En otro
   caso debera retornar false"
  [& xs]
  )

(defn zip-map
  "Escribir una funcion que reciba un vector de claves y un vector de valores, y
   construya un mapa a partir de ellos.
   Restricciones: zipmap"
  [k v]
  )
