package Homework3;

import java.util.*;

/**
 * Created by nicolo on 21/04/17.
 */
public class MyNetwork <T> implements Network <T> {
    public T source = null;
    public T target = null;
    private ArrayList<T> nodes = new ArrayList<T>();
    private ArrayList<Edge<T>> edges = new ArrayList<Edge<T>>();

    @Override
    public T source() {
        return source;
    }

    @Override
    public T target() {
        return target;
    }

    @Override
    public void setSource(T newsource) throws NoSuchNodeException {
        if (nodes.contains(newsource))
            this.source = newsource;
        else throw new NoSuchNodeException();
    }

    @Override
    public void setTarget(T newtarget) throws NoSuchNodeException {
        if (nodes.contains(newtarget))
            this.target = newtarget;
        else throw new NoSuchNodeException();
    }

    @Override
    public void addNode(T v) {
        if (!nodes.contains(v))
            this.nodes.add(v);
    }

    @Override
    public void addEdge(T p, T a) throws NoSuchNodeException {
        if ( !nodes.contains(p) || !nodes.contains(a)) throw new NoSuchNodeException();
        Edge arco = new Edge(p, a);
        edges.add(arco);
    }

    @Override
    public List<T> shortestPath() throws NoSuchPathException {
        if (source == null || target == null) throw new NoSuchPathException(); //’eccezione source o target non sono settati

        //Inizializzazione
        Map<T, T> nextNodeMap = new HashMap<T, T>(); // per memorizzare un nodo e il successivo
        T currentNode = source;

        //Queue
        Queue<T> queue = new LinkedList<T>();
        queue.add(currentNode);

        Set<T> visitedNodes = new HashSet<T>(); // per mantenere i visitati non ci interessa l'ordine per questo usiamo un set
        visitedNodes.add(currentNode);


        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            if (currentNode.equals(target)) {
                break;
            } else {
                for (Edge<T> edge : edges) {
                    if (edge.getP().equals(currentNode)) {
                        T nextNode = edge.getA();
                        if (!visitedNodes.contains(nextNode)) {
                            queue.add(nextNode);
                            visitedNodes.add(nextNode);

                            //Look up of next node instead of previous.
                            nextNodeMap.put(currentNode, nextNode);
                        }
                    }
                }
            }
        }

        //tutti i nodi sono stati esplorati e target non e' stata trovata
        if (!currentNode.equals(target)) {
            throw new NoSuchPathException();
        }

        //Ricostruisce il path piu' breve
        List<T> sPath = new LinkedList<T>();
        for (T node = source; node != null; node = nextNodeMap.get(node)) {
            sPath.add(node);
        }
        if (!sPath.contains(target)) throw new NoSuchPathException(); //se non c'e' un path da source a target
        return sPath;
    }
}