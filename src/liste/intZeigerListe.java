package liste;

import schlange.intZeigerSchlange;

public class intZeigerListe implements intListe {

    private class Node {
        int item;       // data
        Node next;      // next
    }

    private Node first;     // head
    private Node last;
    private int N;          // length

    public intZeigerListe() {
        first = last = null;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int getItem(int index) {
        if( index<0 || index>N-1 ) throw new RuntimeException();
        Node a = getNode(index);
        return a.item;
    }

    @Override
    public void append(int inhalt) {
        insertAt(N, inhalt);
    }

    @Override
    public void insertAt(int index, int inhalt) {
        if( index<0 || index>N ) throw new RuntimeException();

        Node newNode = new Node();
        newNode.item = inhalt;

        // Liste leer
        if( isEmpty() ) {
            last = first = newNode;
        // Liste nicht leer
        } else {
            // hinten anfügen
            if ( index == N ) {
                last.next = newNode;
                last = newNode;
            // vorne anfügen
            } else if ( index==0 ) {
                newNode.next = first;
                first = newNode;
            // "mittig" einfügen
            } else {
                Node a = getNode(index-1);
                newNode.next = a.next;
                a.next = newNode;
            }
        }

        N++;
    }

    @Override
    public void setItem(int index, int inhalt) {
        if( index<0 || index>N-1 ) throw new RuntimeException();
        Node a = getNode(index);
        a.item = inhalt;
    }

    @Override
    public void delete(int index) {
        if( index<0 || index>N-1 ) throw new RuntimeException();

        // vorne löschen
        if( index == 0 ) {
            first = first.next;
        // nicht vorne löschen
        } else  {
            Node a = getNode(index-1);
            a.next = a.next.next;

            // letztes Element gelöscht
            if( a.next == null ) last = a;
        }

        N--;
    }

    @Override
    public int getLength() {
        return N;
    }

    public String toString() {
        String s = "N = " + N + ": ";
        for(Node p = first; p != null; p = p.next){
            s += p.item + " ";
        }
        return s;
    }

    private Node getNode(int index) {
        Node a = first;
        for(int i=0; i<index; i++) a = a.next;
        return a;
    }

    public static void main(String[] argv) {
        intListe l = new intZeigerListe();

        l.append(4);
        l.append(7);
        l.append(13);

        l.insertAt(3, 12);

        System.out.println( l.getItem(3) );
        l.setItem(0, 45);

        System.out.println(l);

        l.delete(3);
        System.out.println(l);
    }
}