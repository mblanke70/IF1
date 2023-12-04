package schlange;

public class StringZeigerSchlange implements StringSchlange {
    private class Node {
        String item;
        Node next;
    }

    private Node first;
    private Node last;
    private int N;

    public StringZeigerSchlange() {
        first = null;
        last = null;
        N = 0;
    }
    public boolean isEmpty() { return N == 0; }
    public void enqueue(String item) {
        Node newNode = new Node();
        newNode.item = item;
        if(isEmpty()) first = newNode;
        else last.next = newNode;
        last = newNode;
        N++;
    }
    public String head() {
        if (isEmpty()) throw new RuntimeException();
        return first.item;
    }
    public String dequeue() {
        if (isEmpty()) throw new RuntimeException();
        String item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;
        return item;
    }
    public String toString() {
        String s = "";
        for (Node p = first; p != null; p = p.next)
            s += p.item + " ";
        return s;
    }
    public int size() { return N; }
}
