package muster;

/**
 * Klasse BinTree zur Umsetzung des ADT Binärbaum entsprechend der Vorgaben
 * des KC Informatik für die gymnasiale Oberstufe in Niedersachsen
 * @author Malte Blanke
 * @version 0.12_20240119
 */
public class LinkedBinTree<E> implements BinTree<E> {
    private class Node {
        E item;
        Node left, right;
        public Node(E item) {
            this.item = item;
        }
    }

    private Node root;

    /*
     * Ein leerer Baum wird erzeugt.
     * Der Baum besitzt keine Wurzel.
     */
    public LinkedBinTree() {
        root = null;
    }

    /**
     * Ein Baum mit dem übergebenen Inhalt als Wert der Wurzel wird erzeugt.
     * Der Baum besitzt keine Teilbäume.
     * @param item Der Inhalt für die Wurzel des neuen Baums.
     */
    public LinkedBinTree(E item) {
        root = new Node(item);
    }

    private LinkedBinTree(Node node) {
        // Interne Hilfsoperation zum Erzeugen eines neuen Baums, bei dem der übergebene Knoten als Wurzel gesetzt wird.
        root = node;
    }

    /**
     * Die Operation prüft, ob der Baum leer ist.
     * @return Wenn der Baum leer ist, wird der Wert true zurückgegeben, sonst der Wert false
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Die Operation gibt den Inhaltswert der Wurzel des Baums zurück.
     * @return Der Inhaltswert der Wurzel.
     */
    public E getItem() {
        return root.item;
    }

    /**
     * Die Operation gibt den linken Teilbaum zurück.
     * Der Teilbaum wird dabei nicht entfernt.
     * @return Der linke Teilbaum.
     */
    public LinkedBinTree<E> getLeft() {
        return new LinkedBinTree<E>(root.left);
    }

    /**
     * Die Operation gibt den rechten Teilbaum zurück.
     * Der Teilbaum wird dabei nicht entfernt.
     * @return Der rechte Teilbaum.
     */
    public LinkedBinTree<E> getRight() {
        return new LinkedBinTree<E>(root.right);
    }

    /**
     * Die Wurzel des Baums erhält den übergebenen Inhalt als Wert.
     * @param item Der neue Inhaltswert für die Wurzel.
     */
    public void setItem(E item) {
        root.item = item;
    }

    /**
     * Der übergebene Baum wird als linker Teilbaum gesetzt.
     * @param left Der Baum, der als linker Teilbaum gesetzt werden soll.
     */
    public void setLeft(BinTree<E> left) { root.left = ((LinkedBinTree<E>) left).root; }

    /**
     * Der übergebene Baum wird als rechter Teilbaum gesetzt.
     * @param right Der Baum, der als rechter Teilbaum gesetzt werden soll.
     */
    public void setRight(BinTree<E> right) { root.right = ((LinkedBinTree<E>) right).root; }

    /**
     * Die Operation prüft, ob der Baum einen linken Teilbaum besitzt.
     * @return Wenn der Baum einen linken Teilbaum besitzt, wird der Wert true zurückgegeben, sonst der Wert false.
     */
    public boolean hasLeft() {
        return root.left != null;
    }

    /**
     * Die Operation prüft, ob der Baum einen rechten Teilbaum besitzt.
     * @return Wenn der Baum einen rechten Teilbaum besitzt, wird der Wert true zurückgegeben, sonst der Wert false.
     */
    public boolean hasRight() {
        return root.right != null;
    }

    /**
     * Die Operation prüft, ob die Wurzel des Baums ein Blatt ist, d.h. ob der Baum keine Teilbäume besitzt.
     * @return Wenn der Baum keine Teilbäume besitzt, wird der Wert true zurückgegeben, sonst der Wert false.
     */
    public boolean isLeaf() {
        return !hasLeft() && !hasRight();
    }
}