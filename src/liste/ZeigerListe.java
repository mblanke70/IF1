package liste;

public class ZeigerListe<E> implements Liste<E> {

    private class Node {
        E item;
        Node next;
    }

    private Node first;
    private Node last;
    private int N;          // length

    public ZeigerListe() {
        first = last = null;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public E getItem(int index) {
        if( index<0 || index>N-1 ) throw new RuntimeException();
        Node a = getNode(index);
        return a.item;
    }

    @Override
    public void append(E inhalt) {
        insertAt(N, inhalt);
    }

    @Override
    public void insertAt(int index, E inhalt) {
        if( index<0 || index>N ) throw new IndexOutOfBoundsException();

        Node newNode = new Node();
        newNode.item = inhalt;

        if ( index==0 ) {  // vorne anfügen
            newNode.next = first;
            first = newNode;
            if( newNode.next == null) last = newNode;
        } else if ( index==N ) {  // hinten anfügen
            last.next = newNode;
            last = newNode;
        } else {  // "mittig" einfügen
            Node a = getNode(index-1);
            newNode.next = a.next;
            a.next = newNode;
        }

        N++;
    }

    @Override
    public void setItem(int index, E inhalt) {
        if( index<0 || index>N-1 ) throw new RuntimeException();
        Node a = getNode(index);
        a.item = inhalt;
    }

    @Override
    public void delete(int index) {
        if( index<0 || index>N-1 ) throw new RuntimeException();

        if( index == 0 ) {  // vorne löschen
            first = first.next;
        } else  {  // nicht vorne löschen
            Node a = getNode(index-1);
            a.next = a.next.next;
            if( a.next == null ) last = a;  // letztes Element gelöscht
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
        Liste l = new ZeigerListe<Integer>();

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