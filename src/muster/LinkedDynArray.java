package muster;

/**
 * Klasse DynArray zur Umsetzung des ADT Dynamische Reihung entsprechend der Vorgaben
 * des KC Informatik für die gymnasiale Oberstufe in Niedersachsen
 * @author Malte Blanke
 * @version 0.11_20231231
 */
public class LinkedDynArray<E> implements DynArray<E> {

    // Klasse Element zur internen Verwaltung der einzelnen Elemente der dynamischen Reihung
    private class Node {
        E item;
        Node next;
    }

    private Node first;
    private Node last;
    private int N;

    /**
     * Eine leere dynamische Reihung wird angelegt.
     */
    public LinkedDynArray() {
        first = last = null;
        N = 0;
    }

    /**
     * Es wird geprüft, ob die dynamische Reihung leer ist.
     * @return Wenn die dynamische Reihung kein Element enthält, wird der Wert true zurückgegeben, sonst der Wert false.
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * Der Inhalte des Elements an der Position index wird ausgelesen.
     * Das Element wird dabei nicht aus der dynamischen Reihung entfernt.
     * @return Der Inhalt des Elements an der Position index.
     * @param index Die Position des auszulesenden Elements.
     */
    public E getItem(int index) {
        if( index < 0 || index > N-1 ) throw new IndexOutOfBoundsException();
        Node a = getNode(index);
        return a.item;
    }

    /**
     * Ein neues Element mit dem übergebenen Inhalt wird am Ende an die dynamische Reihung angefügt.
     * @param item Der Inhalt für das neue Element.
     */
    public void append(E item) {
        insertAt(N, item);
    }

    /**
     * Ein neues Element mit dem übergebenen Inhalt wird der Position index in die dynamische Reihung eingefügt.
     * Das Element, das sich vorher an dieser befunden hat, und alle nachfolgenden Elemente werden nach hinten verschoben.
     * Entspricht der Wert von index der Länge der dynamischen Reihung, so wird ein neues Element am Ende der dynamischen Reihung
     * angefügt.
     * @param index Die Position für das neue Element.
     * @param item Der Inhalt für das neue Element.
     */
    public void insertAt(int index, E item) {
        if( index < 0 || index > N ) throw new IndexOutOfBoundsException();

        Node newNode = new Node();
        newNode.item = item;

        if ( index == 0 ) {  // vorne anfügen
            newNode.next = first;
            first = newNode;
            if( newNode.next == null) last = newNode;
        } else if ( index == N ) {  // hinten anfügen
            last.next = newNode;
            last = newNode;
        } else {  // "mittig" einfügen
            Node a = getNode(index-1);
            newNode.next = a.next;
            a.next = newNode;
        }

        N++;
    }

    /**
     * Der Inhalt des Elements an der Position index wird durch den übergebenen Inhalt ersetzt.
     * @param index Die Position für das Ersetzen.
     * @param item Der neue Inhalt.
     */
    public void setItem(int index, E item) {
        if( index < 0 || index > N-1 ) throw new IndexOutOfBoundsException();
        Node a = getNode(index);
        a.item = item;
    }

    /**
     * Das Element an der Position index wird gelöscht.
     * Alle folgenden Elemente werden um eine Position nach vorne geschoben.
     * @param index Die Position des zu löschenden Elements.
     */
    public void delete(int index) {
        if( index < 0 || index > N-1 ) throw new IndexOutOfBoundsException();

        if( index == 0 ) {  // vorne löschen
            first = first.next;
        } else  {  // nicht vorne löschen
            Node a = getNode(index-1);
            a.next = a.next.next;
            if( a.next == null ) last = a;  // letztes Element gelöscht
        }

        N--;
    }

    /**
     * Die Anzahl der Elemente der dynamischen Reihung wird zurückgegeben.
     * @return Anzahl der enthaltenen Elemente
     */
    public int getLength() {
        return N;
    }

    private Node getNode(int index) {
        // Interne Hilfsoperation zum vereinfachten Zugriff auf die Elemente der dynamischen Reihung.
        Node a = first;
        for(int i=0; i<index; i++) a = a.next;
        return a;
    }
}