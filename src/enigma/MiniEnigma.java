package enigma;

public class MiniEnigma {

    MiniRotor rgt = new MiniRotor("BDGCAEFH");
    MiniRotor mid = new MiniRotor("FBEAGCHD");
    MiniRotor lft = new MiniRotor("FDEABGCH");
    MiniRotor rfl = new MiniRotor("HFGEDBCA");

    public void step() {
        rgt.step();
        if( rgt.getPos() == 0) {
            mid.step();
            if(mid.getPos() == 0) {
                lft.step();
            }
        }
    }

    public char encrypt(char c) {
        step();

        c = rgt.transform(c,1);
        c = mid.transform(c,1);
        c = lft.transform(c,1);

        c = rfl.transform(c,1);

        c = lft.transform(c,0);
        c = mid.transform(c,0);
        c = rgt.transform(c,0);

        return c;
    }

    public static void main(String[] argv) {
        MiniEnigma m = new MiniEnigma();

        String w = "DACHCAFE";
        String g = "";

        for(int i=0; i<w.length(); i++) {
            g += m.encrypt( w.charAt(i) );
        }

        System.out.println(g);
    }
}
