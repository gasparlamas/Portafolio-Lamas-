public class Contador {

//1)
final int MAX_CONT = 50;
int incremento = 1;
int contador = 1;

//2,3) Estructura while

/*public void mostrarContador(){
    while (contador <= MAX_CONT)
    {
        System.out.println(contador);
        contador += incremento;
    }

}*/

//4) Estructura do-while

/*public void mostrarContador(){
    do{
        System.out.println(contador);
        contador += incremento;
    }
    while (contador <= MAX_CONT);
}*/

//5) Estructura for

public void mostrarContador(){
    for (int contador = 1; contador <= MAX_CONT; contador += incremento){
        System.out.println(contador);
    }
}

    public static void main(String[] args) {
        Contador miContador = new Contador();
        miContador.mostrarContador();
    }
}
