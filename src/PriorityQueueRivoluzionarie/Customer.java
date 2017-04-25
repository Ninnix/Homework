package PriorityQueueRivoluzionarie;

/**
 * Created by nicolo on 20/04/17.
 */
public class Customer { // sono gli elementi della priority queue

    public final String nome;
    public final int priorita;

    public Customer (String nome, int priorita) {
        this.nome = nome;
        this.priorita = priorita;
    }
}