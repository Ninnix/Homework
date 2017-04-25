package Homework3;

/**
 * Created by nicolo on 21/04/17.
 */
public class Edge<T> {
    //implementa l'arco
    private T p;
    private T a;

    public Edge(T partenza, T arrivo) {
        this.p = partenza;
        this.a = arrivo;
    }

    public T getP() {   //restituisce il nodo di partenza dell'arco
        return this.p;
    }

    public T getA() {   //restituisce il nodo di arrivo dell'arco
        return this.a;
    }
}
