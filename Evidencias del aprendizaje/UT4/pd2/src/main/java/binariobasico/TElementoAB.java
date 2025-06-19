package binariobasico;

public class TElementoAB<T> implements IElementoAB {

    private TElementoAB<T> hijoDer;
    private TElementoAB<T> hijoIzq;
    private Comparable<T> etiqueta;
    private T datos;
    private int contador;
    

    public TElementoAB(Comparable etiqueta, T datos){
        this.etiqueta = etiqueta;
        this.datos = datos;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public TElementoAB getHijoIzq() {
        return this.hijoIzq;
    }

    @Override
    public TElementoAB getHijoDer() {
        return this.hijoDer;
    }

    @Override
    public void setHijoIzq(TElementoAB elemento) {
        this.hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(TElementoAB elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public TElementoAB buscar(Comparable unaEtiqueta, int[] contador) {
        contador[0] += 1;
        if (unaEtiqueta.compareTo(etiqueta) == 0) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return hijoIzq.buscar(unaEtiqueta, contador);
            } else {
                return null;
            }
        } else {
            if (hijoDer != null) {
                return hijoDer.buscar(unaEtiqueta, contador);
            } else {
                return null;
            }
        }
    }

    public boolean eliminar (TElementoAB elemento){

        return false;
    }

    @Override
    public boolean insertar(TElementoAB elemento) {
        if (elemento.etiqueta.compareTo(etiqueta) == 0) {
            return false;
        } else if (elemento.etiqueta.compareTo(etiqueta) < 0) {
            if (this.getHijoIzq() != null) {
                return hijoIzq.insertar(elemento);
            } else {
                this.hijoIzq = elemento;
                return true;
            }
        } else {
            if (this.getHijoDer() != null) {
                return hijoDer.insertar(elemento);
            } else {
                this.hijoDer = elemento;
                return true;
            }
        }
    }

    @Override
    public String preOrden() {
        String tempstr = "";
        System.out.println(tempstr);
        if(hijoIzq != null){
            tempstr =hijoIzq.preOrden();
        }
        if (hijoDer != null) {
            tempstr = tempstr + hijoDer.preOrden();
        }
        return  tempstr;

    }

    @Override
    public String inOrden() {
        String tempstr = "";
        if(hijoIzq != null){
            tempstr =hijoIzq.inOrden() + " ";
        }
        tempstr = tempstr + this.etiqueta  + " ";
        if (hijoDer != null) {
            tempstr = tempstr + hijoDer.inOrden()  + " ";
        }

        return  tempstr;
    }

    @Override
    public String postOrden() {
        String tempstr = "";
        if(hijoIzq != null){
            tempstr =hijoIzq.postOrden();
        }
        if (hijoDer != null) {
            tempstr = tempstr + hijoDer.postOrden();
        }
        System.out.println(tempstr);
        return  tempstr;
    }
    
    @Override
    public T getDatos() {
        return this.datos;
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.getEtiqueta())<0){
            if (this.getHijoIzq()!=null){
                this.setHijoIzq(this.getHijoIzq().eliminar(unaEtiqueta));
            }
            return this;
        }
        if (unaEtiqueta.compareTo(this.getEtiqueta())>0){
            if (this.getHijoDer()!=null){
                this.setHijoDer(this.getHijoDer().eliminar(unaEtiqueta));
            }
            return this;
        }
        return this.quitaelnodo();
    }

    public TElementoAB quitaelnodo(){
        if (this.getHijoIzq() == null){
            return this.getHijoDer();
        }
        if (this.getHijoDer() == null){
            return this.getHijoIzq();
        }
        TElementoAB Hijo = this.getHijoIzq();
        TElementoAB Padre = this;
        while (Hijo.getHijoDer() != null) {
            Padre = Hijo;
            Hijo = Hijo.getHijoDer();
        }
        if (Padre != this){
            Padre.setHijoDer(Hijo.getHijoIzq());
            Hijo.setHijoDer(this.getHijoIzq());
        }
        Hijo.setHijoDer(this.getHijoDer());
        return Hijo;
    }

    public int altura() {
        int alturaizq = 0;
        int alturader = 0;
        if (this.getHijoIzq() != null) {
            alturaizq = this.hijoIzq.altura();
        }
        if (this.getHijoDer() != null) {
            alturader = this.hijoDer.altura();
        }

        if (alturaizq > alturader) {
            return alturaizq + 1;
        } else {
            return alturader + 1;
        }
    }

    public int tamanio() {
        int contador = 1;
        if (this.getHijoIzq() != null) {
            contador += hijoIzq.tamanio();
        }
        if (this.getHijoDer() != null) {
            contador += hijoDer.tamanio();
        }
        return contador;
    }




    
}