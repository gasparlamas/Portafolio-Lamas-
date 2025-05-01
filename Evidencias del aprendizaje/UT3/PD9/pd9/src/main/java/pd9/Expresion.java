package pd9;
import java.util.List;
import java.util.Stack;

public class Expresion {
    public static void main(String[] args) {
        
    }

    public static boolean controlCorchetes(List<String> listaEntrada){
       
    Stack<String> pila = new Stack<>();
    for (String corchete : listaEntrada) {
        if (corchete.equals("{")) {
            pila.push("{");
        } else if (corchete.equals("}")) {
            if (!pila.isEmpty()) {
                pila.pop();
            } else {
                return false;
            }
        }
    }
    return pila.isEmpty();
    }
}

