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
            rtl[i] = (c - (i+65) + 8) % 8;
            ltr[c-65] = (8 - rtl[i]) % 8;
        }

        System.out.println(Arrays.toString(rtl));
        System.out.println(Arrays.toString(ltr));
    }

    public char transform(char c, int dir) { // 1: rtl, 0: ltr
        if(dir == 1) {
            return (char) (((c-65) + rtl[(c-65-pos+8) % 8]) % 8 + 65);
        } else {
            return (char) (((c-65) + ltr[(c-65-pos+8) % 8]) % 8 + 65);
        }
    }

    public void step() {
        pos = (pos+1) % 8;
    }

    public int getPos() {
        return pos;
    }

}
