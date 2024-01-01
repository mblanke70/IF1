package baum;

public class LinkedBinTree<E> {
    private class Node {
        E item;
        Node left;
        Node right;

        public Node(E item) {
            this.item = item;
            left = right = null;
        }
    }

    private Node root;

    /*
     * Ein leerer Baum wird erzeugt.
     * Der Baum besitzt keine Teilbäume. Die Wurzel besitzt keinen Inhalt.
     */
    public LinkedBinTree() {
        root = null;
    }
    public LinkedBinTree(E item) {
        root = new Node(item);
    }

    private LinkedBinTree(Node root) {
        this.root = root;
    }

    // Die Operation gibt den Inhaltswert der Wurzel des Baumes zurück.
    public E getItem() {
        return root.item;
    }

    // Die Operation gibt den linken Teilbaum zurück.
    public LinkedBinTree<E> getLeft() {
        return new LinkedBinTree<E>(root.left);
    }

    // Die Operation gibt den rechten Teilbaum zurück.
    public LinkedBinTree<E> getRight() {
        return new LinkedBinTree<E>(root.right);
    }

    // Die Wurzel des Baums erhält den übergebenen Inhalt als Wert.
    public void setItem(E item) {
        root.item = item;
    }

    // Der übergebene Baum wird als linker Teilbaum gesetzt.
    public void setLeft(LinkedBinTree<E> left) {
        root.left = left.root;
    }

    // Der übergebene Baum wird als rechter Teilbaum gesetzt.
    public void setRight(LinkedBinTree<E> right) {
        root.right = right.root;
    }

    // Die Operation löscht den Inhaltswert der Wurzel des Baums.
    public void deleteItem() {
        root.item = null;
    }

    // Die Operation löscht den linken Teilbaum.
    public void deleteLeft() {
        root.left = null;
    }

    // Die Operation löscht den rechten Teilbaum.
    public void deleteRight() {
        root.right = null;
    }

    // Wenn die Wurzel des Baums einen Inhaltswert besitzt, wird der Wert wahr zurückgegeben, sonst der Wert falsch.
    public boolean hasItem() {
        return root.item != null;
    }

    // Wenn der Baum einen linken Teilbaum besitzt, wird der Wert wahr zurückgegeben, sonst der Wert falsch.
    public boolean hasLeft() {
        return root.left != null;
    }

    // Wenn der Baum einen rechten Teilbaum besitzt, wird der Wert wahr zurückgegeben, sonst der Wert falsch.
    public boolean hasRight() {
        return root.right != null;
    }

    public boolean isLeaf() { return !hasLeft() && !hasRight(); }

    public boolean isEmpty() { return root == null; }
}