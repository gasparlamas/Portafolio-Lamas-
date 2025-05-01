public class Alumno {
    private String nombre;

    public Alumno () {
        //nombre = null;
        //a) Indicar el error al ejecutar la clase Alumno y corregirlo. ¿cómo lo detectaste?
        //El error me indica que no puede concatenar un string si el valor de nombre es null, por lo que debo inicializarlo como una cadena vacia ("").
        nombre = "juancho";
    }

    public String getNombreAdmiracion() {
        return nombre.concat("!");
    }

    public static void main (String[] args) {
        Alumno alumno = new Alumno();
        System.out.println(alumno.getNombreAdmiracion());

        //b) Ejecución del método recorrer
        String cadena = "Gonzalo";
        int resultado = recorrer(cadena);
        System.out.println(resultado);
        /*Busqué las condiciones de un bucle en java y note que la sentencia original (i <=cadena.length()) estaba incorrecta.
         Si se pone <= el bucle va a intentar acceder a un caracter fuera del indice de la cadena, por lo que arroja un error de "IndexOutOfBoundsException"
         También note que i en el for estaba inicializado con 1, pero al probar el método sobre la cadena "juancho", la cual tiene 7 caracteres, note que
         El método recorrer decia que esta cadena tenia 6 caractéres, por lo que lo cambie a 0 y arrojó el valor correcto.*/
        
        //c) Ejecución del método getValor
        int valor = alumno.getValor();
        System.out.println(valor);
        /*Al ejecutar el método devuelve el error "IndexOutOfBoundsException"
         note que vector tiene 8 indices, los cuales se accederian del 0 al 7, sin embargo, en la sentencia de abajo de su declaración
         se quiere acceder al indice 8 (int idx = 8), el cuál no es accesible ya que sobrepasa la cantidad de valores que contiene vector.
         Para que el código se ejecute correctamente se debe seleccionar cualquier indice del 0 a 7.*/

        //d) Ejecución del método getPrimerCaractér
        char primerCaracter = getPrimerCaracter("");
        System.out.println(primerCaracter);
        /*En la sentencia (String string[] = new String[5]) se estaba inicializando un array de 5 elementos pero sin especificar los mismos.
         Esto genera que los 5 elementos sean null, por lo que el método no puede encontrar un caractér para devolver
         Retorna el error "NullPointerException" y dice que el valor que busca es null
         Para solucionar esto incialicé el array con 5 strings cualquiera y el método devolvió correctamente la segunda letra de la segunda cadena*/

        //e) Ejecución del método parAString
        int numero = 23;
        String conversión = paraAString(numero);
        System.out.println(conversión);
        /*Al ejecutar el método devuelve el error "ClassCasrException", lo que significa que no pudo convertir de Integer a String.
         Busqué un comando para convertir un int a str de forma directa y String.valueof(int) lo hace.
         */
    }

    public static int recorrer (String cadena) {
        int res = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != ' ') {
                res++;
            }
        }
        return res;  
        
    }
    

    public static int getValor() {
        int vector[] = { 6, 16, 26,36,46,56,66,76 };
        //int idx = 8;
        int idx = 7;
        return vector[idx];
    }

    public static char getPrimerCaracter(String palabra) {
        //String string[] = new String[5];
        String string[] = {"papa","zapallo","ricota","berenjena","tomate"};
        return (string[1].charAt(1));
    }

    public static String paraAString(int a) {
        //Object x1 = new Integer(a);
        //return (String) (x1) ;
        return String.valueOf(a);
    }
}

    