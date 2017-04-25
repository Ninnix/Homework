package PriorityQueueRivoluzionarie;

/**
 * Created by nicolo on 21/04/17.
 */
public class CustomerQueue extends Coda<Customer> {
    // Coda di Customer etichettata con priorita'

    public final int priorita;

    public CustomerQueue (int priorita) {
        this.priorita = priorita;
    }
}
