package schlange;

public interface Schlange<E> {
    public void enqueue(E x);
    public E dequeue();
    public E head();
    public boolean isEmpty();
}
