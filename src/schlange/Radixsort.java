package schlange;

import java.util.Arrays;

public class Radixsort {

    public static void main(String[] argv) {

        String[] zahlen = {"124", "523", "483", "128", "923", "584"};
        StringSchlange[] buckets = new StringSchlange[10];

        for(int i=0; i<buckets.length; i++){
            buckets[i] = new StringArraySchlange(10);
        }

        for(int j=2; j>=0; j--) {

            // aufteilen
            for (int i = 0; i < zahlen.length; i++) {
                String x = zahlen[i];
                buckets[ x.charAt(j) - 48 ].enqueue( x );
            }

            // aufsammeln
            int idx = 0;
            for(int i=0; i<buckets.length; i++) {
                while( !buckets[i].isEmpty() ){
                    zahlen[idx++] = buckets[i].dequeue();
                }
            }

        }

        System.out.println(Arrays.toString(zahlen));
    }
}
