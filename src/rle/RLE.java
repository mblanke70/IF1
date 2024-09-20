package rle;

public class RLE {

    // Aufgabe 1:
    // 11111000 => 035
    // 00000111 => 35
    public static String compress1(String in) {
        String out = "";
        char old = '0';
        int  cnt = 0;

        for(int i=0; i<in.length(); i++) {
            char b = in.charAt(i);
            if( b != old) {
                out += cnt;
                cnt = 0;
                old = b;
            }
            cnt++;
        }

        out += cnt;
        return out;
    }

    public static String expand1(String in) {
        String out = "";
        char b = '0';

        for(int i=0; i<in.length(); i++) {
            int cnt = in.charAt(i) - 48;
            for(int k=0; k<cnt; k++) {
                out += b;
            }
            b = (b == '0') ? '1' : '0';
        }

        return out;
    }

    // Aufgabe 2:
    // AAAABBBCCCCCCAA => 4A3B5C2A
    public static String compress2(String in) {
        String out = "";
        char old = in.charAt(0);
        int  cnt = 1;

        for(int i=1; i<in.length(); i++) {
            char b = in.charAt(i);
            if( b != old) {
                out += cnt + "" + old;
                cnt = 0;
                old = b;
            }
            cnt++;
        }

        out += cnt + "" + old;
        return out;
    }

    public static String expand2(String in) {
        String out = "";

        for(int i=0; i<in.length(); i+=2) {
            int cnt = in.charAt(i) - 48;
            char b = in.charAt(i+1);

            for(int k=0; k<cnt; k++) {
                out += b;
            }
        }

        return out;
    }

    // Aufgabe 3:
    // AAAABBBCCCCCCCCCCCCAA => 4A3B59C3C3A
    public static String compress3(String in) {
        String out = "";
        char old = in.charAt(0);
        int  cnt = 1;

        for(int i=1; i<in.length(); i++) {
            char b = in.charAt(i);
            if( b != old) {
                out += cnt + "" + old;
                cnt = 0;
                old = b;
            }
            else {
                if( cnt == 9 ) {
                    out += cnt + "" + b;
                    cnt = 0;
                }
            }
            cnt++;
        }

        out += cnt + "" + old;
        return out;
    }

    public static String expand3(String in) {
        String out = "";

        for(int i=0; i<in.length(); i+=2) {
            int cnt = in.charAt(i) - 48;
            char b = in.charAt(i+1);

            for(int k=0; k<cnt; k++) {
                out += b;
            }
        }

        return out;
    }

    public static String compress4(String in) {
        String out = "";
        char old = in.charAt(0);
        int cnt = 1;

        for (int i = 1; i < in.length(); i++) {
            char b = in.charAt(i);
            if (b != old) {
                out += intToBinaryString( cnt ) + intToBinaryString( (int) old );
                cnt = 0;
                old = b;
            } else {
                if (cnt == 256) {
                    out += intToBinaryString( cnt ) + intToBinaryString( (int) old );
                    cnt = 0;
                }
            }
            cnt++;
        }

        out += intToBinaryString( cnt ) + intToBinaryString( (int) old );
        return out;
    }

    public static String expand4(String in) {
        String out = "";

        for(int i=0; i<in.length(); i+=16) {
            int cnt = Integer.parseInt( in.substring(i,i+8), 2);
            char b  = (char) Integer.parseInt( in.substring(i+8,i+16), 2);

            for(int k=0; k<cnt; k++) {
                out += b;
            }
        }

        return out;
    }

    public static void main(String[] argv) {
        System.out.println( "11100000 => " + compress1("11100000") ); // 035
        System.out.println( "035 => " + expand1("035"));
        System.out.println();
        System.out.println( "AAAABBBCCCCCCAA => " + compress2("AAAABBBCCCCCCAA") ); // 4A3B6C2A
        System.out.println( "4A3B6C2A = > " + expand2("4A3B6C2A"));
        System.out.println();
        System.out.println( "AAAABBBCCCCCCCCCCCCAA => " + compress3("AAAABBBCCCCCCCCCCCCAA") ); // 4A3B9C3C2A
        System.out.println( "4A3B9C3C2A = > " + expand3("4A3B9C3C2A"));
        System.out.println();
        System.out.println( "AAAABBCCC => " + compress4("AAAABBCCC") ); // 000001000100000100000010010000100000001101000011
        System.out.println( "000001000100000100000010010000100000001101000011 = > " + expand4("000001000100000100000010010000100000001101000011"));
        System.out.println( "000001000100000100000010010000100000001101000011".length() + " : " + "AAABBCCC".length()*8 );
    }

    // Wandelt eine Zahl im Bereich [0..255] in eine 8-Bit Binärzahl in String-Darstellung
    public static String intToBinaryString(int i) {
        return String.format( "%8s", Integer.toBinaryString(i) ).replace(' ', '0');
    }
}