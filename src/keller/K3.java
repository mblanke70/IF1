package keller;

public class K3 {

    public static boolean istPrim(int n) {
        for(int i=2; i<n;i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static intKeller pfz2(int n){
        intKeller s = new intZeigerKeller();
        for(int i=2; i<n; i++) {
            if (istPrim(i)) {
                int k = n;
                while (k%i == 0) {
                    s.push(i);
                    k = k/i;
                }
            }
        }
        return s;
    }

    public static intKeller pfz(int n){
        intKeller s = new intZeigerKeller();
        for(int i=2; i<n; i++) {
            if (istPrim(i)) {
                if (n%i == 0) {
                    s.push(i);
                }
            }
        }
        return s;
    }

    public static void reduziere(intKeller zKeller, intKeller nKeller) {
        intKeller hilf1 = new intZeigerKeller();
        intKeller hilf2 = new intZeigerKeller();

        while(!zKeller.isEmpty() && !nKeller.isEmpty()) {
            if (zKeller.top() > nKeller.top()) {
                hilf1.push(zKeller.pop());
            } else if (zKeller.top() < nKeller.top()) {
                hilf2.push(nKeller.pop());
            } else {
                zKeller.pop();
                nKeller.pop();
            }
        }

        while(!hilf1.isEmpty()) { zKeller.push(hilf1.pop()); }
        while(!hilf2.isEmpty()) { nKeller.push(hilf2.pop()); }
    }

    public static void main(String[] argv) {
        //System.out.println(pfz(48));

        intKeller zKeller = pfz2(48);
        intKeller nKeller = pfz2(82);

        System.out.println(zKeller);
        System.out.println(nKeller);

        reduziere(zKeller, nKeller);

        System.out.println(zKeller);
        System.out.println(nKeller);
    }
}
