package Homework1;

/**
 * Created by nicolo on 20/04/17.
 */
public class testcode {
    public static void main(String[] args) {
        // test sulle code

        Coda c = new Coda();
        if (c.is_empty())
            System.out.println("coda inizialmente vuota");

        try {
            for (int i = 0; i < 100; i++)
                c.inserisci(i);
            while (c.is_empty() == false)
                System.out.println(c.estrai());
            c.inserisci(7);
            c.inserisci(9);
            System.out.println(c.estrai()); // stampa 7
            c.estrai();
            c.estrai();
        }
        catch (Coda_Vuota_Exception e) {
            System.out.println("eccezione catturata!");
        }
    }
}
