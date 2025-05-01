package pd7;

public class Main {
    public static void main(String[] args) {

        Conjunto<Integer> primerConjunto = new Conjunto<>();
        Conjunto<Integer> segundoConjunto = new Conjunto<>();

        Nodo<Integer> nodo1 = new Nodo<>(1, 1);
        Nodo<Integer> nodo2 = new Nodo<>(4, 4);
        Nodo<Integer> nodo3 = new Nodo<>(3, 3);
        Nodo<Integer> nodo4 = new Nodo<>(4, 4);

        primerConjunto.insertarC(nodo1);
        primerConjunto.insertarC(nodo2);
        segundoConjunto.insertarC(nodo4);
        segundoConjunto.insertarC(nodo3);

        Conjunto<Integer> opUnion = primerConjunto.opUnion(primerConjunto, segundoConjunto);
        System.out.println("Unión: ");
        opUnion.conjImprimir();

        Conjunto<Integer> opInterseccion = primerConjunto.opInterseccion(primerConjunto, segundoConjunto);
        System.out.println("Intersección: ");
        opInterseccion.conjImprimir();

        // Implementación con alumnos
        Conjunto<TAlumno> AED1 = new Conjunto<>();
        Conjunto<TAlumno> PF = new Conjunto<>();
        TAlumno alumno1 = new TAlumno(1234, "alumno1");
        TAlumno alumno2 = new TAlumno(7352, "alumno2");
        TAlumno alumno3 = new TAlumno(8462, "alumno3");
        TAlumno alumno4 = new TAlumno(3451, "alumno4");

        Nodo<TAlumno> a1 = new Nodo<>(alumno1.getCedula(), alumno1);
        Nodo<TAlumno> a2 = new Nodo<>(alumno2.getCedula(), alumno2);
        Nodo<TAlumno> a3 = new Nodo<>(alumno3.getCedula(), alumno3);
        Nodo<TAlumno> a4 = new Nodo<>(alumno4.getCedula(), alumno4);

        AED1.insertarC(a1);
        AED1.insertarC(a3);
        AED1.insertarC(a4);
        PF.insertarC(a2);
        PF.insertarC(a4);

        Conjunto<TAlumno> opUnion2 = AED1.opUnion(AED1, PF);
        System.out.println("La unión de los conjuntos es: ");
        opUnion2.conjImprimir();
        Conjunto<TAlumno> opInterseccion2 = AED1.opInterseccion(AED1, PF);
        System.out.println("La intersección de los conjuntos es: ");
        opInterseccion2.conjImprimir();
    }
}