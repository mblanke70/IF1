package stapel;

public class PFZ {
    public static boolean istPrim(int n) {
        for(int i=2; i<=Math.sqrt(n); i++) {
            if( n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static intKeller pfz2(int n) {
        intKeller s = new intZeigerKeller();
        for(int i=2; i<n; i++) {
            if( istPrim(i) ) {
                int k = n;
                while ( k % i == 0 ) {
                    s.push(i);
                    k = k / i;
                }
            }
        }
        return s;
    }

    public static void reduziere() {


    }
    public static intKeller zStapel = pfz2(420);
    public static intKeller nStapel = pfz2(450);

    public static void main(String[] argv) {
        System.out.println( zStapel );
        System.out.println( nStapel );

        reduziere();

        System.out.println( zStapel );
        System.out.println( nStapel );
    }
}
