package ut6pd3;
import java.util.Map;
import java.util.Objects;

public class Ejercicio1 {
    
    public static void SacarNulls(Map<?, ?> map) {
        map.values().removeIf(Objects::isNull); // se utiliza el método remove if para sacar todo elemento con la condición que se indique, en este caso los nulls
    }

}
