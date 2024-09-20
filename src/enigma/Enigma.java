package enigma;

import java.util.HashMap;

public class Enigma {

    private static final Rotor[] ROTOREN = {
        new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 18),  // Rotor 1
        new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 6),   // Rotor 2
        new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", 23),  // Rotor 3
        new Rotor("ESOVPZJAYQUIRHXLNFTGKDCMWB", 11),  // Rotor 4
        new Rotor("VZBRGITYUPSDNHLXAWMJQOFECK", 0)    // Rotor 5
    };
    private static final Rotor REFLEKTOR =
        new Rotor("YRUHQSLDPXNGOKMIEBFZCWVJAT", -1);  // Reflektor B

    private HashMap<Character,Character> steckerbrett = new HashMap<Character, Character>();

    public void step() {
        rotoren[2].step();
        if( rotoren[2].getPos() == rotoren[2].getCarryPos() ||
            rotoren[1].getPos()+1 == rotoren[1].getCarryPos()) {    // double step
            rotoren[1].step();
            if(rotoren[1].getPos() == rotoren[1].getCarryPos()) {
                rotoren[0].step();
            }
        }
    }

    private Rotor[] rotoren = new Rotor[3];    // left, mid, right

    public Enigma(String walzenlage, String ringstellung, String stecker) {
        for(int i=0; i<3; i++) {
            rotoren[i] = ROTOREN[ walzenlage.charAt(i)-49 ];
        }

        for(int i=0; i<3; i++) {
            rotoren[i].setRingstellung(ringstellung.charAt(i)-65);
        }

        for(int i=0; i<stecker.length(); i+=2) {
            steckerbrett.put(stecker.charAt(i), stecker.charAt(i+1));
            steckerbrett.put(stecker.charAt(i+1), stecker.charAt(i));
        }
    }

    public char encrypt(char c) {
        step();

        if(steckerbrett.containsKey(c)) {
            c = steckerbrett.get(c);
        }

        c = rotoren[2].transform(c,1);
        c = rotoren[1].transform(c,1);
        c = rotoren[0].transform(c,1);

        c = REFLEKTOR.transform(c,1);

        c = rotoren[0].transform(c,0);
        c = rotoren[1].transform(c,0);
        c = rotoren[2].transform(c,0);

        if(steckerbrett.containsKey(c)) {
            c = steckerbrett.get(c);
        }

        return c;
    }

    public String encrypt(String input, String grundstellung) {
        for(int i=0; i<3; i++) {
            rotoren[i].setPos(grundstellung.charAt(i) - 65);
        }

        String output = "";
        for(int i=0; i<input.length(); i++) {
            output += encrypt(input.charAt(i));
        }
        return output;
    }

    public static void main(String[] argv) {
        Enigma m = new Enigma("123","BXD","AFGZXDCWJOPNTBISQMKL");

        String g = m.encrypt("AACHENISTGERETTET","TGQ");

        System.out.println(g); // Ausgabe: EBPYVCLUXWZZVAZIX, EnigmaSim: EBPYVULUXWZZVAZIX

        String teil1 = "EDPUD NRGYS ZRCXN" +
                "UYTPO MRMBO FKTBZ REZKM" +
                "LXLVE FGUEY SIOZV EQMIK" +
                "UBPMM YLKLT TDEIS MDICA" +
                "GYKUA CTCDO MOHWX MUUIA" +
                "UBSTS LRNBZ SZWNR FXWFY" +
                "SSXJZ VIJHI DISHP RKLKA" +
                "YUPAD TXQSP INQMA TLPIF" +
                "SVKDA SCTAC DPBOP VHJK";

        String teil2 = "SFBWD NJUSE GQOBH" +
                "KRTAR EEZMW KPPRB XOHDR" +
                "OEQGB BGTQV PGVKB VVGBI" +
                "MHUSZ YDAJQ IROAX SSSNR" +
                "EHYGG RPISE ZBOVM QIEMM" +
                "ZCYSG QDGRE RVBIL EKXYQ" +
                "IRGIR QNRDN VRXCY YTNJR";

        teil1 = teil1.replaceAll(" ", "");
        teil2 = teil2.replaceAll(" ", "");

        Enigma m3 = new Enigma("245","BUL","AVBSCGDLFUHZINKMOWRX");

        String spruchschlüssel1 = m3.encrypt("KCH","WXC");
        System.out.println(m3.encrypt(teil1, spruchschlüssel1));

        String spruchschlüssel2 = m3.encrypt("YPJ","CRS");
        System.out.println(m3.encrypt(teil2, spruchschlüssel2));
    }
}