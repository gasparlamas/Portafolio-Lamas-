public class ToStringDemo {
    public static void main(String[] args) {
        double d = 888.51;
        String s = Double.toString(d);
        int dot = s.indexOf('.');
        System.out.println(dot + " digits " +
            "before decimal point.");
        System.out.println((s.length() - dot - 1) +
            " digits after decimal point.");
    }
}

// 1)
//La salida obtenida al ejecutarlo indicara que hay 3 digitos antes del punto decimal y 2 digitos despues de este:
// "3 digits before decimal point."
// "2 digits after decimal point."

// 2)
/*Lo primero que hace el programa es convertir una variable double a un string.
Utiliza el método indexOf para encontrar la posición del punto (.) en la cadena.
System.out.println(dot + " digits " + "before decimal point."); Imprime la cantidad de digitos que van antes de el caracter punto, ya teniendo su posición.
System.out.println((s.length() - dot - 1) + " digits after decimal point."); Hace lo mismo que el anterior pero cuenta los que están despues del punto.
 */