package muster;

/**
 * Klasse LinkedStack zur Umsetzung des ADT Stapel entsprechend der Vorgaben
 * des KC Informatik für die gymnasiale Oberstufe in Niedersachsen
 * @author Malte Blanke
 * @version 0.11_20231231
 */
public class LinkedStack<E> implements Stack<E> {

    // Klasse Node zur internen Verwaltung der einzelnen Elemente des Stapels
    private class Node {
        E item;
        Node next;
    }

    private Node top;
    private int N;

    /**
     * Ein leerer Stapel wird angelegt.
     */
    public LinkedStack() {
        top = null;
        N = 0;
    }

    /**
     * Es wird geprüft, ob der Stapel leer ist.
     * @return Wenn der Stapel kein Element enthält, wird der Wert true zurückgegeben, sonst der Wert false.
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * Ein neues Element mit dem übergebenen Inhalt wird auf dem Stapel abgelegt.
     * @param item Der Inhalt für das neue Element.
     */
    public void push(E item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = top;
        top = newNode;
        N++;
    }

    /**
     * Der Inhalt des obersten Elements des Stapels wird ausgelesen.
     * Das Element wird dabei nicht aus dem Stapel entfernt.
     * @return Der Inhalt des obersten Elements des Stapels.
     */
    public E top() {
        if( isEmpty() ) throw new RuntimeException();
        return top.item;
    }

    /**
     * Das erste Element des Stapels wird entnommen und dessen Inhalt zurückgegeben.
     * @return Der Inhalt des entnommenen Elements.
     */
    public E pop() {
        if( isEmpty() ) throw new RuntimeException();
        E item = top.item;
        top = top.next;
        N--;
        return item;
    }
}