package Homework1;

/**
 * Created by nicolo on 20/04/17.
 */
public class Coda {
    // implementa le code come liste linkate
    class Node {
        public int item;
        public Node next;

        public Node (int val) {
            item = val;
        }
    }

    private Node front;
    private Node end;

    public boolean is_empty() {
        // restituisce true se la coda è vuota, false altrimenti
        return front == null;
    }

    public void inserisci(int v)  {
        //inserisce un intero all' inizio della coda
        Node newNode = new Node(v);
        if (is_empty())
            front = newNode;
        else
            end.next = newNode;
        end = newNode;
    }

    public int estrai() throws Coda_Vuota_Exception {
        //estrae l'elemento in fondo alla coda(e lo restituisce) ... se esiste!
        if (front == null) throw new Coda_Vuota_Exception();
        int temp = front.item;
        if (front.next == null)
            end = null;
        front = front.next;
        return temp;
    }
}

class Coda_Vuota_Exception extends Exception {}

