package liste;

/*
 * Die Nummerierung der Elemente der dynamischen Reihung beginnt mit dem Index 0.
 */
public interface intListe {

    /*
     * isEmpty(): Wahrheitswert
     * Wenn die dynamische Reihung kein Element enthält, wird der Wert wahr zurückgegeben,
     * sonst der Wert falsch.
     */

    boolean isEmpty();
    /*
     * getItem(index: Ganzzahl): Inhaltstyp
     * Der Inhalt des Elements an der Position index wird zurückgegeben.
     */
    int getItem(int index);

    /*
     * append(inhalt: Inhaltstyp)
     * Ein neues Element mit dem übergebenen Inhalt wird am Ende der dynamischen Reihung
     * angefügt.
     */
    void append(int inhalt);

    /*
     * insertAt(index: Ganzzahl, inhalt: Inhaltstyp)
     * Ein neues Element mit dem übergebenen Inhalt wird an der Position index in die dynamische
     * Reihung eingefügt. Das Element, das sich vorher an dieser Position befunden hat, und alle
     * nachfolgenden werden nach hinten verschoben. Entspricht der Wert von index der Länge der
     * dynamischen Reihung, so wird ein neues Element am Ende der dynamischen Reihung angefügt.
     */
    void insertAt(int index, int inhalt);

    /*
     * setItem(index: Ganzzahl, inhalt: Inhaltstyp)
     * Der Inhalt des Elementes an der Position index wird durch den übergebenen Inhalt ersetzt.
     */
    void setItem(int index, int inhalt);

    /*
     * delete(index: Ganzzahl)
     * Das Element an der Position index wird entfernt. Alle folgenden Elemente werden um eine
     * Position nach vorne geschoben.
     */
    void delete(int index);

    /*
     * getLength(): Ganzzahl
     * Die Anzahl der Elemente der dynamischen Reihung wird zurückgegeben.
     */
    int getLength();
}