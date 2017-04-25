package PriorityQueueRivoluzionarie;

/**
 * Created by nicolo on 20/04/17.
 */
public class Coda <E> {
    /* implementazione con linked list
    del tipo di dato astratto delle code
    */

    protected MyListElem<E> first = null; // da qui si estrae
    protected MyListElem<E> last = null; // qui si inserisce

    public boolean isEmpty () {
        return (first == null);
    }

    public void insert (E elem) {
        if (first == null) first = last = new MyListElem<E>(elem);
        else {
            last.next = new MyListElem<E>(elem);
            last = last.next;
        }
    }

    public E extract () throws NoSuchCustomerException {
        if (first == null) throw new NoSuchCustomerException();
        E result = first.value;
        first = first.next;
        if (first == null) last = null;
        return result;
    }
}
