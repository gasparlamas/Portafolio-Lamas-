package pd3;

public class Main {
    public static void main(String[] args) {
        
        ILista<String> lista = new Lista<>();
        lista.insertar("clave 1", "dato 1");
        lista.insertar("clave 2", "dato 2");
        lista.insertar("clave 3", "dato 3");
        System.out.println("Lista con elementos insertados: " + lista.imprimir());
        System.out.println(" ");

        String buscado = lista.buscar("clave 2");
        System.out.println("El elemento encontrado es: " + buscado);
        System.out.println("");

        boolean eliminar1 = lista.eliminar("dato 1");
        boolean eliminar2 = lista.eliminar("dato 4"); //No está en la lista
        System.out.println("El elemento se pudo eliminar? " + eliminar1);
        System.out.println("El elemento se pudo eliminar? " + eliminar2);
        System.out.println("La lista despues de eliminar un elemento es: " + lista.imprimir());
        System.out.println("");

        String impreso = lista.imprimir();
        System.out.println("La lista impresa es: " + impreso);
        System.out.println("");

        int elementos = lista.cantElementos();
        System.out.println("La cantidad de elementos en la lista es: " + elementos);
        System.out.println("");

        boolean vacia = lista.esVacia();
        System.out.println("La lista está vacia? " + vacia);

    }
}