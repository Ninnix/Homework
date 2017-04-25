package PriorityQueueRivoluzionarie;

/**
 * Created by nicolo on 21/04/17.
 */
public class TestRevolution {

    public static void main(String[] args) throws NoSuchCustomerException {

        RevolutionQueue rq = new RevolutionQueue();

        rq.insert(new Customer("pippo",88));
        rq.insert(new Customer("paperoga",100));
        rq.insert(new Customer("pluto",10));
        rq.insert(new Customer("paperino",20));
        rq.insert(new Customer("minnie",10));
        rq.insert(new Customer("gastone",100));

        System.out.println(rq.extractCustomer().nome);
        System.out.println(rq.extractCustomer().nome);
        System.out.println(rq.extractCustomer().nome);

        rq.revolution();
        System.out.println("rivoluzione!");

        System.out.println(rq.extractCustomer().nome);
        System.out.println(rq.extractCustomer().nome);
        System.out.println(rq.extractCustomer().nome);
        // rq.extractCustomer(); // non lo fare!

    }

}