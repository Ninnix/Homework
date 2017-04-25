package Homework2;

/**
 * Created by nicolo on 20/04/17.
 */
import java.util.ArrayList;

public class MyIntTree implements IntTree {
    public int val;
    public ArrayList<MyIntTree> children = new ArrayList<MyIntTree>();

    public MyIntTree(int v) {
        //costruttore
        this.val = v;
    }

    @Override
    public int getValue() {
        // restituisce il valore associato alla radice
        return this.val;
    }

    @Override
    public int childrenNumber() {
        // restituisce il numero di figli di this (0 se e' una foglia)
        return children.size();
    }

    @Override
    public int nodes() {
        // restituisce il numero di nodi di this; 1 se this una foglia
        int nodes = 1;
        for (MyIntTree node : this.children)
            nodes += node.nodes();
        return nodes;
    }

    @Override
    public int height() {
        // restituisce la lunghezza del cammino piu' lungo dalla radice a una foglia
        int h = -1;
        for (MyIntTree t : children) {
            h = Math.max(h, t.height());
        }
        return ++h;
    }

    @Override
    public boolean equals(IntTree t) {
        /* t1.equals(t2) e' true se t1 e t2 sono isomorfi,
        * ovvero indistunguibili ad un osservatore esterno */
        if ((this.getValue() != t.getValue())) return false;
        if (this.childrenNumber() != t.childrenNumber()) return false;
        for (int i = 0; i < this.children.size(); i++) { //per ora controlla il solo primo livello dei figli
            //this.children.get(i).equals(((MyIntTree) t).children.get(i));  // possibile soluzione ma non funziona
            if (this.children.get(i).getValue() != ((MyIntTree) t).children.get(i).getValue()) return false;
        }
        return true;
    }

    @Override
    public void addChild(IntTree child) {
        // aggiunge child come primo figlio di this
        this.children.add(0, (MyIntTree) child);
    }

    @Override
    public IntTree followPath(int[] path) throws NoSuchTreeException {
        /* restituisce il sottoalbero individuato da path. Ad esempio, se path = [2,3,1],
        * restituisce il primo figlio del terzo figlio del secondo figlio di this;
        * se un tale sottoalbero non esiste lancia NoSuchTreeException */
        MyIntTree currentTree = this;
        for (int p : path) {
            if (currentTree.children.size() < p) throw new NoSuchTreeException();
            currentTree = currentTree.children.get(p - 1);
        }
        return currentTree;
    }

    @Override
    public void visit() {
        /* stampa la sequenza di valori associati ai nodi dell'albero corrispondente
        * ad una visita in profondita' (depth-first) pre-order */
        this.vis();
        System.out.println();

    }

    public void vis() {
        System.out.printf("%d ", this.getValue());
        if (children != null) {
            for (MyIntTree t : children) {
                t.vis();
            }
        }
    }

    @Override
    public void printIntTree(){
        // pritty prints this, usando le parentesi
        this.print();
        System.out.println();
    }

    public void print(){
        System.out.print("(" + this.getValue());
        for (MyIntTree t : this.children) {
            t.print();
        }
        System.out.print(")");
    }
}

