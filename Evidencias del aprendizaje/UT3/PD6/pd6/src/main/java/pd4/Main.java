package pd4;

public class Main {
    public static void main(String[] args) {

        //Creacion de la LinkedList para cada archico de sucursales
        //suc1
        pregunta1suc1(enlistarSucursales("C:/Users/Gaspar/OneDrive - Universidad Católica del Uruguay/Escritorio/JAVA/UTA 3/PD6/pd6/src/main/java/pd4/suc1.txt"));
        System.out.println("");
        //suc2
        pregunta2suc1(enlistarSucursales("C:/Users/Gaspar/OneDrive - Universidad Católica del Uruguay/Escritorio/JAVA/UTA 3/PD6/pd6/src/main/java/pd4/suc1.txt"));
        System.out.println("");
        pregunta4suc3(enlistarSucursales("C:/Users/Gaspar/OneDrive - Universidad Católica del Uruguay/Escritorio/JAVA/UTA 3/PD6/pd6/src/main/java/pd4/suc1.txt"));
        pregunta3suc2(enlistarSucursales("C:/Users/Gaspar/OneDrive - Universidad Católica del Uruguay/Escritorio/JAVA/UTA 3/PD6/pd6/src/main/java/pd4/suc2.txt"));
        System.out.println("");
        
        
        //sucursales
        pregunta4suc3(enlistarSucursales("C:/Users/Gaspar/OneDrive - Universidad Católica del Uruguay/Escritorio/JAVA/UTA 3/PD6/pd6/src/main/java/pd4/suc3.txt"));
       
    }

    public static ILista<String> enlistarSucursales(String nombreArchivo){
        ManejadorArchivosGenerico ArchivoALeer = new ManejadorArchivosGenerico();
        String[] lineasArchivo = ArchivoALeer.leerArchivo(nombreArchivo);
        ILista<String> suc = new Lista<>();
        for (String cadaLinea : lineasArchivo){
            suc.insertar(cadaLinea, cadaLinea);
        }
        return suc;
    }
    

    public static void pregunta1suc1(ILista<String> archivo){
        int elementosSuc1 = archivo.cantElementos();
        System.out.println("El numero de elementos que hay es: " + elementosSuc1);
    }

    public static void pregunta2suc1(ILista<String> archivo){
        boolean borrarChic = archivo.eliminar("Chicago");
        System.out.println(borrarChic);
    }

    public static void pregunta3suc2(ILista<String> archivo){
        boolean borrarTok = archivo.eliminar("Tokio");
        boolean borrarShen = archivo.eliminar("Shenzu");
        System.out.println(borrarTok);
        System.out.println(borrarShen);
    }

    public static void pregunta4suc3(ILista<String> archivo){
        String resultado = archivo.imprimir(";_");
        System.out.println(resultado);
    }

}