public class ValueOfDemo {
    public static void main(String[] args) {
        // this program requires two
        // arguments on the command line
        //if (args.length == 3) {
        if (args.length == 2) { // Cambio 3 por 2 ya que el requerimiento es mínimo 2
            // convert strings to numbers
            //float a = (Float.value (args[0])).floatValue();
            float a = (Float.valueOf(args[0])).floatValue(); // Agrego "Of" a value ya que no estaba
            a = 5;
            //float b = (Float.valueOf(args[1])).float ();
            float b = (Float.valueOf(args[1])).floatValue(); // Agrego "Value" a float
            b= 2;
            // do some arithmetic
            System.out.println("a + b = " + (a + b));
            System.out.println("a - b = " + (a - b));
            System.out.println("a * b = " + (a * b));
            System.out.println("a / b = " + (a / b));
            System.out.println("a % b = " + (a % b));
        } else {
            System.out.println("This program requires two command-line arguments.");
        }
    }
}

//1) La salida usando los valores 13.4 y 66.1 será:
/*a + b = 79.5
a - b = -52.7
a * b = 882.74
a / b = 0.20242649
a % b = 13.4*/

//2) Para asegurar que los 2 valores sean positivos deberia agregar una condicíon en el if.
/*if (a <= 0 || b <= 0) {
    System.out.println("Los argumentos deben ser enteros positivos.");
 } else {
    // Realizar algunas operaciones aritméticas
    System.out.println("a + b = " + (a + b));
    System.out.println("a - b = " + (a - b));
    System.out.println("a * b = " + (a * b));
    System.out.println("a / b = " + (a / b));
    System.out.println("a % b = " + (a % b)); */
