package muster;

public interface Stack<E> {

    // Wenn der Stapel kein Element enthält, wird der Wert wahr zurückgegeben, sonst der Wert falsch.
    boolean isEmpty();

    // Der Inhalt des obersten Elements des Stapels wird zurückgegeben, das Element aber nicht entnommen.
    void push(E x);

    // Ein neues Element mit dem übergebenen Inhalt wird oben auf den Stapel gelegt.
    E top();

    // Das oberste Element des Stapels wird entnommen. Der Inhalt dieses Elements wird zurückgegeben.
    E pop();
}
