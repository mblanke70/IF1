package asym;

import java.math.BigInteger;
import java.util.Arrays;

public class EA {

    // iterativ
    public static int ggT1(int a, int b) {
        while ( b>0 ) {
            int q = a / b;
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    // rekursiv
    public static int[] ggT2(int a, int b) {

        // Abbruchbedingung prüfen; Rückgabe: {ggT, x, y}
        if( b==0 ) return new int[] {a, 1, 0};

        int[] erg = ggT2(b, a % b); // rekursiver Aufruf mit Wertrückgabe

        int x_neu = erg[2];
        int y_neu = erg[1] - erg[2] * (a/b);

        return new int[] {erg[0], x_neu, y_neu};
    }

    public static BigInteger[] eea(BigInteger a, BigInteger b) {

        // Abbruchbedingung prüfen
        if( b.compareTo(BigInteger.ZERO) == 0  )
            return new BigInteger[] {a, BigInteger.ONE, BigInteger.ZERO};

        BigInteger[] erg = eea( b, a.mod(b) ); // rekursiver Aufruf mit Wertrückgabe

        BigInteger x_neu = erg[2];
        BigInteger y_neu = erg[1].subtract( erg[2].multiply( a.divide(b) ) );

        return new BigInteger[] {erg[0], x_neu, y_neu};
    }

    public static void main(String[] argv) {

        BigInteger M = new BigInteger("1000010000100001000010000100001000010000100001000010000");
        BigInteger p = new BigInteger("49");

        BigInteger q = eea(M,p)[2];
        System.out.println( q.add(M) ); // q = 775517959261225265313877628572204089387832653836742449

        BigInteger i = BigInteger.ONE;
        long start = System.currentTimeMillis();
        BigInteger b = new BigInteger("500000000");
        while( i.compareTo(b) < 0 ) {
            if( i.multiply(p).mod(M).compareTo(BigInteger.ONE) == 0) {
                System.out.println("Gefunden " + i);
                break;
            }
            i = i.add(BigInteger.ONE);
        }
        long stop = System.currentTimeMillis();
        System.out.println( (stop-start) / 1000.0 );
    }
}
