package muster;

public interface BinTree<E> {

    // Wenn der Baum eine Wurzel besitzt, wird der Wert true zurückgegeben, sonst der Wert falsch.
    boolean isEmpty();

    // Die Operation gibt den Inhaltswert der Wurzel des Baumes zurück.
    E getItem();

    // Die Operation gibt den linken Teilbaum zurück.
    BinTree<E> getLeft();

    // Die Operation gibt den rechten Teilbaum zurück.
    BinTree<E> getRight();

    // Die Wurzel des Baums erhält den übergebenen Inhalt als Wert.
    void setItem(E item);

    // Der übergebene Baum wird als linker Teilbaum gesetzt.
    void setLeft(BinTree<E> left);

    // Der übergebene Baum wird als rechter Teilbaum gesetzt.
    void setRight(BinTree<E> right);

    // Wenn der Baum einen linken Teilbaum besitzt, wird der Wert wahr zurückgegeben, sonst der Wert falsch.
    boolean hasLeft();

    // Wenn der Baum einen rechten Teilbaum besitzt, wird der Wert wahr zurückgegeben, sonst der Wert falsch.
    boolean hasRight();

    // Wenn der Baum keine Teilbäume besitzt, die Wurzel des Baums also ein Blatt ist,
    // wird der Wert wahr zurückgegeben, sonst der Wert falsch.
    boolean isLeaf();
}
