package ut6pd3;
import java.util.*;

public class Ejercicio3 {

    public class OrdenarStrings {
        public static void main(String[] args) {
            
            List<String> strings = Arrays.asList("perro", "gato", "ciudad", "java", "cancun", "motor");
    
            Collections.sort(strings, new Comparator<String>() { // ordenar las cadenas según longitud y despues lexicográficamente
                @Override
                public int compare(String s1, String s2) {
                    int compareByLength = Integer.compare(s1.length(), s2.length()); // comparar por longitud primero
                    if (compareByLength != 0) {
                        return compareByLength;
                    } else {
                        return s1.compareTo(s2); // si tienen la misma longitud, comparar lexicográficamente
                    }
                }
            });
    
            System.out.println("Cadenas ordenadas según longitud y despues lexicográficamente:"); // imprimir las cadenas ordenadas
            for (String str : strings) {
                System.out.println(str);
            }
        }
    }
    
}
