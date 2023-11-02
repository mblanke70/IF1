package keller;

public interface intKeller {

    // liefert true, falls Keller leer, sonst false
    public boolean isEmpty();

    // legt neues Element x auf den Keller
    public void push(int x);

    // liefert das oberste Kellerelement
    public int peek();

    // löscht das oberste Kellerelement und liefert es zurück
    public int pop();

}
