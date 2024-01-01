package muster;

public interface Queue<E> {

    // Wenn die Schlange kein Element enthält, wird der Wert wahr zurückgegeben, sonst der Wert falsch.
    boolean isEmpty();

    // Der Inhalt des vordersten Elements der Schlange wird zurückgegeben, das Element aber nicht entnommen.
    void enqueue(E x);

    // Das vorderste Element wird entnommen. Der Inhalt dieses Elements wird zurückgegeben.
    E dequeue();

    // Ein neues Element mit dem angegebenen Inhalt wird am Ende an die Schlange angehängt.
    E head();
}

