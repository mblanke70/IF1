package schlange;

public class Queue<E> {
    private class Node {
        E item;
        Node next;
    }

    private Node first;
    private Node last;
    private int N;

    public Queue() {
        first = null;
        last = null;
        N = 0;
    }
    public boolean isEmpty() { return N == 0; }
    public void enqueue(E item) {
        Node newNode = new Node();
        newNode.item = item;
        if(isEmpty()) first = newNode;
        else last.next = newNode;
        last = newNode;
        N++;
    }
    public E head() {
        if (isEmpty()) throw new RuntimeException();
        return first.item;
    }
    public E dequeue() {
        if (isEmpty()) throw new RuntimeException();
        E item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;
        return item;
    }
    public String toString() {
        String s = "";
        for (Node p = first; p != null; p = p.next)
            s = p.item + " " + s;
        return s;
    }
    public int size() { return N; }
}
