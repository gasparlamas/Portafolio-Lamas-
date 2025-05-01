public class App {
    
    //1)
    public class Parte1{
        /*String[] students = new String[10];
        String studentName = "Peter Parker";
        students[0] = studentName;
        studentName = null;*/
    
        //Al momento de ejecutarse el programa existe una referencia al array de students y al "studentName", sin embargo a este objeto
        //Se le asigna el valor null, por lo que ya no va a haber una referencia hacia este.
        //Debido a esto, se convertirá en candidato para el recolector de basura, ya que no tiene una referencia y solo estaria ocupando espacio de memoria.
    }

    //2)
    //La herramienta "Recolector de basura" se encarga de buscar los objetos que no tienen referencia o "Inalcazables" y eliminarlos
    //Para liberar la memoria que ocupan.

    //3)
    public static class NumberHolder {
        public int anInt;
        public float aFloat;
        }
    
    public static void main(String[] args) throws Exception {
        NumberHolder myInt = new NumberHolder(); 
        NumberHolder myFloat = new NumberHolder(); //Creo instancias de la clase NumberHolder
        myInt.anInt = 2;
        myFloat.aFloat = 4; //Inicializo las variables
        System.out.println("El valor de myInt es= " + myInt.anInt);
        System.out.println("El valor de myFlaot es = " + myFloat.aFloat); //Muestro las variables

        

        
    }
}
