package Esonero;

/**
 * Created by nicolo on 25/04/17.
 */
public class MyBinTree implements BinTree {

    public int data;
    public BinTree left;
    public BinTree right;

    public MyBinTree(int d) { //primo costruttore
        this.data = d;
        this.left = null;
        this.right = null;
    }

    public MyBinTree(int d, BinTree left, BinTree right) { //secondo costruttore
        this.data = d;
        this.left = left;
        this.right = right;
    }

    @Override
    public int root() {
        return this.data;
    }

    @Override
    public BinTree leftChild() {
        return this.left;
    }

    @Override
    public BinTree rightChild() {
        return this.right;
    }

    @Override
    public void times(BinTree t) {
        if (this.left != null && this.right != null) {
            this.left.times(t);
            this.right.times(t);
        }
        else {
            if (this.left == null && this.right == null ) { //se e' una foglia
                this.data = t.root();
                this.left = t.leftChild();
                this.right = t.rightChild();
            }
        }
    }
}