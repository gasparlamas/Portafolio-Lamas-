package binariobasico;

public class TArbolBB<T> implements IArbolBB<T>{

    private TElementoAB<T> raiz;
    public int contador;

    public TArbolBB() {
        this.raiz = null;
    }

    @Override
    public boolean insertar(Comparable unaEtiqueta, Object dato) {
        if (esVacio()){
            this.contador++;
            raiz = new TElementoAB(unaEtiqueta, dato);
            return true;
        }
        else {
            this.contador++;
            //TElementoAB elemento = new TElementoAB(unaEtiqueta, dato);
            return raiz.insertar(new TElementoAB(unaEtiqueta, dato));
        }
    }

    @Override
    public TElementoAB buscar(Comparable unaEtiqueta, int[] contador) {
        contador[0]= 0;
        if (esVacio()) {
            return null;
        } else {
            System.out.println(contador);
            return raiz.buscar(unaEtiqueta,contador);
        }
    }

    @Override
    public String preOrden() {
        if (esVacio()){
            return "arbol vacio";
        }else {
            return raiz.preOrden();
        }
    }

    @Override
    public String inOrden() {
        if (esVacio()){
            return "arbol vacio";
        }else {
            return raiz.inOrden();
        }
    }

    @Override
    public String postOrden() {
        if (esVacio()){
            return "arbol vacio";
        }else {
            return raiz.postOrden();
        }
    }

    @Override
    public T eliminar(Comparable unaEtiqueta) {
        return null;
    }

    private boolean esVacio(){
        return raiz == null;
    }
}
