package enigma;

import java.util.Arrays;

public class MiniRotor {
    private int pos;
    private int[] rtl, ltr;

    public MiniRotor(String cfg) {
        rtl = new int[8];
        ltr = new int[8];
        pos = 0;

        for(int i=0; i<8; i++) {
            char c = cfg.charAt(i);

            // berechne RTL-Verschiebungszahl, die zum Buchstaben c gehört
            // und speichere diese in rtl an Position i
        }

        System.out.println(Arrays.toString(rtl));
    }

    public static void main(String[] argv) {
        MiniRotor r = new MiniRotor("BDGCAEFH");
    }

}
