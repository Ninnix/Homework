package Homework3;

/**
 * Created by nicolo on 21/04/17.
 */
public class TestNetwork {
    public static void main(String[] args) {
        MyNetwork rete = new MyNetwork();
        rete.addNode(1);
        rete.addNode(2);
        rete.addNode(3);
        rete.addNode(4);
        rete.addNode(5);
        rete.addNode(6);
        rete.addNode(7);
        try {
            rete.setSource(1);
            rete.setTarget(5);
            rete.addEdge(1, 3);
            rete.addEdge(2, 3);
            rete.addEdge(2, 4);
            //rete.addEdge(4, 5);
            rete.addEdge(3, 6);
            rete.addEdge(6, 7);
            rete.addEdge(7, 5);
        } catch (NoSuchNodeException e) {
            System.out.println("Eccezione operazione su un nodo che non appartiene alla rete");
        }
        try {
            rete.shortestPath();
        }catch (NoSuchPathException f) {
            System.out.println("Eccezione source o target non sono settati o non c’e’ path che collega il primo al secondo");
        }
    }
}
