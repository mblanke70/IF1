package liste;

import schlange.*;

public class Abi23_1C {
    public static Queue<Dominostein> q = new Queue<Dominostein>();
    public static DynArray<Dominostein> vorrat = new DynArray<Dominostein>();

    public static void main(String[] argv) {
        q.enqueue(new Dominostein(2,3));
        q.enqueue(new Dominostein(3,4));

        System.out.println(q);

        System.out.println( ringPrüfen() );
    }

    public static boolean ringPrüfen() {

        boolean istRing = true;

        for(int i=0; i<q.size(); i++) {

            Dominostein d1 = q.dequeue();
            Dominostein d2 = q.head();

            q.enqueue(d1);
            if(d1.getRechts() != d2.getLinks()) {
                istRing = false;
            }
        }

        return istRing;
    }

}
