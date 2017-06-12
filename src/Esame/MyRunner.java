package Esame;

/**
 * Created by nicolo on 12/06/17.
 */
public class MyRunner extends Runner {


    public MyRunner(String nome, Pista p, int delay) {
        super(nome, p, delay);
    }

    @Override
    public void run() {
        while ( !p.arrivato()){
            p.step();
            try {
                sleep(delay);
            } catch (InterruptedException e) {
                System.out.println(this.getName() + " preso!");
                break;
            }
            p.leave();
            p = p.getNext();
        }
    }
}