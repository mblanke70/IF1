package keller;

public class Palindrom {

    public static boolean istPalindrom(String p) {
        intKeller k = new intArrayKeller(20);

        for(int i=0; i<p.length()/2; i++) {
            k.push( (int) p.charAt(i) );
        }

        int j = p.length() / 2;
        if( p.length() % 2 == 1) j++;

        for(int i=j; i<p.length(); i++) {
            if( k.pop() != (int) p.charAt(i) ) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String p ="reittier";
        System.out.println( istPalindrom(p) );
    }
}