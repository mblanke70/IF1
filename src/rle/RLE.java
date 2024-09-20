package rle;

public class RLE {

    public static String rle1(String bits) {
        String code = "";
        int N = bits.length();
        int i=0;
        int k;

        while( i<N ) {
            k = 1;
            while( i+k<N && bits.charAt(i)==bits.charAt(i+k) ) {
                k++;
            }
            code += k + " ";
            i += k;
        }

        return code;
    }

    public static void main(String[] argv) {
        String code = rle1("00000111");

        System.out.println( code );
    }
}