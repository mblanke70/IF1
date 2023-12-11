package liste;

public class DynArray<E> {

    private class Node {
        E item;       // data
        Node next;      // next
    }

    private Node first;     // head
    private Node last;
    private int N;          // length

    public DynArray() {
        first = last = null;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public E getItem(int index) {
        if( index<0 || index>N-1 ) throw new IndexOutOfBoundsException();
        Node a = getNode(index);
        return a.item;
    }

    public void append(E inhalt) {
        insertAt(N, inhalt);
    }

    public void insertAt(int index, E inhalt) {
        if( index<0 || index>N ) throw new IndexOutOfBoundsException();

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

    public void setItem(int index, E inhalt) {
        if( index<0 || index>N-1 ) throw new IndexOutOfBoundsException();
        Node a = getNode(index);
        a.item = inhalt;
    }

    public void delete(int index) {
        if( index<0 || index>N-1 ) throw new IndexOutOfBoundsException();

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
        DynArray l = new DynArray<Integer>();

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