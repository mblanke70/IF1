package stapel;

public interface Keller<E> {
    public boolean isEmpty();
    public void push(E x);
    public E top();
    public E pop();
}
