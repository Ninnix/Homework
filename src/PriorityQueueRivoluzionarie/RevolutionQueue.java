package PriorityQueueRivoluzionarie;

/**
 * Una priority queue rivoluzionaria (PQR) è una priority queue, con priorità espressa da numeri interi,
 * dotata di un metodo revolution() che inverte l'ordine di priorità. Ad esempio, supponendo che una PQR q
 * si trovi in uno stato in cui elementi con alta priorità vengono estratti prima di quelli con priorità bassa,
 * dopo l'invocazione di q.revolution(), verranno estratti per primi gli elementi con priorità minore;
 * una successiva invocazione del metodo inverte nuovamente l'ordine e così via. Elementi con uguale priorità
 * vengono comunque estratti in ordine di arrivo. La tradizionale implementazione di priority queue attraverso
 * un heap (dunque, usando la classe java.util.PriorityQueue) non è adatta per le PQR, dato che ogni rivoluzione
 * richiederebbe una totale riorganizzazione dello heap per invertire l'ordine di priorità. Alternativamente,
 * le PQR potrebbero essere implementate usando java.util.Hashtable. L'implementazione che proponiamo è tutta
 * fatta in casa, a partire da una semplice implementazione del tipo di dato astratto delle code.
 */
public class RevolutionQueue extends Coda <CustomerQueue> {

    private int state = 1;
    //  1: si estrae dalla priorita' piu' grande;
    // -1: si estrae dalla priorita' piu' piccola

    private MyListElem<CustomerQueue> scorri (int prio) {
        /*
        restituisce null se this RevolutionQueue e' vuota
        oppute se first ha priorita strettamente minore di prio;
        altrimenti scorre this  e restutuisce il MyListElem
        il cui *next* (eventualmente null) e' il primo della
        lista ad avere priorita strettamente minore di prio;
        */

        if (isEmpty() || first.value.priorita < prio) return null;
        MyListElem<CustomerQueue> result = first;
        while (result.next != null && result.next.value.priorita >= prio)
            result = result.next;
        return result;
    }

    public void revolution() {
        /*
        La rivoluzione cambia verso alle priorita': se prima della
        rivoluzione erano privilegiati gli utenti con priorita' piu'
        alta, dopo la rivoluzione lo saranno quelli con prioritÃ  piu'
        bassa, e vice versa.
        */
        state = - state;
    }

    public void insert (Customer cst) { // overloading
        /*
        Indipendentemente da stato (rivoluzione o no), gli utenti (customer)
        vengono sempre inseriti in ordine di priorita' (priorita' bassa in fondo)
        */

        MyListElem<CustomerQueue> q = scorri(cst.priorita);
        if (q != null && q.value.priorita == cst.priorita)
            // in questo caso non bisogna creare un nuovo elemento da aggiungere alla coda
            q.value.insert(cst);
        else {
            CustomerQueue c = new CustomerQueue(cst.priorita);
            c.insert(cst);

            if (isEmpty()) super.insert(c); // invocato il metodo della superclasse Coda
            else { // bisogna creare "a mano" un nuovo elemento della coda
                MyListElem<CustomerQueue> nuovoelem = new MyListElem<CustomerQueue>(c);

                if (q == null) { // nuovoelem deve essere inserito in testa
                    nuovoelem.next = first;
                    first = nuovoelem;
                } else { // nuovoelem deve essere inserito dopo q
                    nuovoelem.next = q.next;
                    q.next = nuovoelem;
                    if (q == last) last = nuovoelem;
                }
            }
        }

    }

    public Customer extractCustomer () throws NoSuchCustomerException {

        if (isEmpty()) throw new NoSuchCustomerException();
        Customer result = null;

        switch (state) {
            case 1: // si estrae dalla priorita' piu' alta

                result = first.value.extract(); // ovvero (in ordine di arrivo) dalla prima coda
                if (first.value.isEmpty()) { // se la prima coda rimane vuota, va rimossa
                    if (first == last) last = null;
                    first = first.next;
                }
                break;

            case -1: // si estrae dalla priorita' piu' bassa

                result = last.value.extract(); // ovvero (in ordine di arrivo) dall'ultima coda
                if (last.value.isEmpty()) {
                    /* se l'ultima coda rimane vuota, va rimossa;
                    occorre posizionarsi sul penultimo elemento della coda
                     */
                    MyListElem<CustomerQueue> q = scorri(result.priorita + 1);
                    if (q == null) // avviene quando first = last; nessun customer in coda!
                        first = last = null;
                    else { // q punta al penultimo elemento della coda
                        q.next = null;
                        last = q;
                    }
                }
                break;
        }
        return result;
    }
}
