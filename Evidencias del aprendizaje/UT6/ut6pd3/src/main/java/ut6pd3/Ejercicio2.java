package ut6pd3;
import java.util.HashMap;
import java.util.Map;


public class Ejercicio2 {

    public class IntercambiadorMap {
        public static Map<String, String> invertirMap(Map<String, String> original) throws IllegalArgumentException { // uso el método invertMap tomando un mapa original de referencia
            Map<String, String> invertido = new HashMap<>(); // creo un nuevo mapa llamado invertido para mostrar el resultado
            for (Map.Entry<String, String> entry : original.entrySet()) { // itera sobre cada entrada del original
                String key = entry.getKey();
                String value = entry.getValue();
                
                if (invertido.containsKey(value)) {
                    throw new IllegalArgumentException("Valor repetido: " + value); // si la clave ya está en el mapa invertido lanza un aviso
                }
                invertido.put(value, key);
            }
            return invertido;
        }
    }
    
}
