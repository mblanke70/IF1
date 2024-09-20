package enigma;

import java.util.Arrays;

public class Rotor {
    private int pos;
    private int[] rtl, ltr;
    private int carryPos;

    private int ringstellung;

    public Rotor(String cfg, int p) {
        carryPos = p;
        pos = 0;

        rtl = new int[26];
        ltr = new int[26];

        for(int i=0; i<26; i++) {
            char c = cfg.charAt(i);
            rtl[i]    = (c  - (i+65) + 26) % 26;
            ltr[c-65] = (26 - rtl[i]     ) % 26;
        }

        //System.out.println(Arrays.toString(rtl));
        //System.out.println(Arrays.toString(ltr));
    }

    public void setRingstellung(int r) {
        ringstellung = r;
    }

    public int getCarryPos() {
        return carryPos;
    }

    public void setPos(int p) {
        pos = p;
    }

    public char transform(char c, int dir) { // 1: rtl, 0: ltr
        if(dir == 1) {
            return (char) (((c-65) + rtl[(c-65+pos-ringstellung+26) % 26]) % 26 + 65);
        } else {
            return (char) (((c-65) + ltr[(c-65+pos-ringstellung+26) % 26]) % 26 + 65);
        }
    }

    public void step() { pos = (pos+1) % 26; }

    public int getPos() {
        return pos;
    }

    public static void main(String[] argv) {
        Rotor r = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 18);

        char c = r.transform('A', 1);
        System.out.println(c);

        r.step();

        c = r.transform('A', 1);
        System.out.println(c);

        r.step();

        c = r.transform('A', 1);
        System.out.println(c);
    }
}
