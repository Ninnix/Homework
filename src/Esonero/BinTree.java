package Esonero;

/**
 * Created by nicolo on 25/04/17.
 */

/*
Un albero binario di interi è un grafo orientato aciclico finito costituito da un nodo,
chiamato radice, etichettato da un intero, e, eventualmente, un figlio destro e un
figlio sinistro, anch’essi alberi binari di interi. Non esiste l’albero vuoto (senza nodi).
Se un nodo ha figli, allora ne ha esattamente due. Un albero con un solo nodo
(ovvero senza figli) è chiamato foglia.

Definire una classe MyBinTree che rappresenti il tipo di dato astratto degli
alberi binari di interi, implementando la seguente interfaccia BinTree:
 */
public interface BinTree {

    int root ();
    // restituisce l'intero che etichetta la radice di this

    BinTree leftChild ();
    // restituisce il figlio sinistro

    BinTree rightChild ();
    // restituisce il figlio destro

    void times (BinTree t);
    // sostituisce ogni foglia di this con t
}

/*
Esempio.
Supponiamo di rappresentare un albero con radice etichettata da n, figlio sinistro t1
e figlio destro t2 mediante una tripla (n, t1, t2), e supponiamo che (n) rappresenti
una foglia etichettata con n; supponiamo che t0 sia l’albero (1, (2), (3)), e t sia
l’albero (4, (5), (6)) allora, dopo l’esecuzione di t0.times(t), t0 sarà l’albero
(1, (4, (5), (6)), (4, (5), (6))).
 */