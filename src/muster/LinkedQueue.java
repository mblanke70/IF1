package muster;

/**
 * Klasse LinkedQueue zur Umsetzung des ADT Schlange entsprechend der Vorgaben
 * des KC Informatik für die gymnasiale Oberstufe in Niedersachsen
 * @author Malte Blanke
 * @version 0.11_20231231
 */
public class LinkedQueue<E> implements Queue<E> {

    // Klasse Node zur internen Verwaltung der einzelnen Elemente der Schlange
    private class Node {
        E item;
        Node next;
    }

    private Node first;
    private Node last;
    private int N;

    /**
     * Eine leere Schlange wird angelegt.
     */
    public LinkedQueue() {
        first = last = null;
        N = 0;
    }

    /**
     * Es wird geprüft, ob die Schlange leer ist.
     * @return Wenn die Schlange kein Element enthält, wird der Wert true zurückgegeben, sonst der Wert false.
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * Ein neues Element mit dem übergebenen Inhalt wird an die Schlange angehängt.
     * @param item Der Inhalt für das neue Element.
     */
    public void enqueue(E item) {
        Node newNode = new Node();
        newNode.item = item;
        if(isEmpty()) first = newNode;
        else last.next = newNode;
        last = newNode;
        N++;
    }

    /**
     * Der Inhalt des ersten Elements der Schlange wird ausgelesen.
     * Das Element wird dabei aber nicht aus der Schlange entfernt.
     * @return Der Inhalt des ersten Elements der Schlange.
     */
    public E head() {
        if ( isEmpty() ) throw new RuntimeException();
        return first.item;
    }

    /**
     * Das erste Element der Schlange wird entnommen und dessen Inhalt zurückgegeben.
     * @return Der Inhalt des entnommenen Elements.
     */
    public E dequeue() {
        if ( isEmpty() ) throw new RuntimeException();
        E item = first.item;
        first = first.next;
        N--;
        if ( isEmpty() ) last = null;
        return item;
    }
}