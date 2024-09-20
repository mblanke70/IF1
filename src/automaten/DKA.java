package automaten;
import java.util.Stack;
public class DKA {

    private Stack<Character> keller = new Stack();
    private int zustand;    // 0 (Startzustand), 1, 2, 3, 4, 5 (Fehlerzustand)
    private String eingabe;

    public DKA(String e) {
        eingabe = e;
        zustand = 0;
        keller.push('#');
    }
    public void work() {
        for(int i=0; i<eingabe.length(); i++) {
            step( eingabe.charAt(i) );
            System.out.println( zustand );
        }

        if( keller.peek() == '#' && zustand == 3 ) {
            System.out.println("korrekt");
        } else {
            System.out.println("falsch");
        }
    }
    // Hier werden die Regeln des Automaten umgesetzt...
    public void step(char c) {
        switch( zustand ) {
            case 0:
                if( keller.peek() == '#' && c == 'a') {
                    keller.push('A');
                    zustand = 1;
                } else {
                    zustand = 5;    // Fehler
                }
                break;
            case 1:
                if( keller.peek() == 'A' && c == 'a') {
                    keller.push('A');
                    zustand = 1;
                } else if ( keller.peek() == 'A' && c == 'b' ) {
                    zustand = 2;
                } else {
                    zustand = 5;    // Fehler
                }
                break;
            case 2:
                if ( keller.peek() == 'A' && c == 'c' ) {
                    keller.pop();
                    zustand = 3;
                } else {
                    zustand = 5;    // Fehler
                }
                break;
            case 3:
                if ( keller.peek() == 'A' && c == 'c' ) {
                    keller.pop();
                    zustand = 3;
                } else {
                    zustand = 5;    // Fehler
                }
                break;
        }
    }

    public static void main(String[] argv) {
        DKA ka = new DKA("aabcc");
        ka.work();
    }
}