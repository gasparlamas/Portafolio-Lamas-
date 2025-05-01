package pd9;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<String> entrada1 = new ArrayList<>();
        entrada1.add("{");
        entrada1.add("}");
        System.out.println("Prueba 1: " + Expresion.controlCorchetes(entrada1)); // Caso de prueba correcto
        
        List<String> entrada2 = new ArrayList<>();
        entrada2.add("{");
        entrada2.add("{");
        entrada2.add("}");
        System.out.println("Prueba 2: " + Expresion.controlCorchetes(entrada2)); // Caso de prueba incorrecto
        
        List<String> entrada3 = new ArrayList<>();
        entrada3.add("{");
        entrada3.add("}");
        entrada3.add("{");
        entrada3.add("{");
        entrada3.add("}");
        entrada3.add("}");
        System.out.println("Prueba 3: " + Expresion.controlCorchetes(entrada3)); //  Caso de prueba correcto
        
        List<String> entrada4 = new ArrayList<>();
        entrada4.add("{");
        entrada4.add("{");
        entrada4.add("}");
        entrada4.add("}");
        entrada4.add("{");
        entrada4.add("{");
        entrada4.add("{");
        System.out.println("Prueba 4: " + Expresion.controlCorchetes(entrada4)); //  Caso de prueba incorrecto
    }
}
