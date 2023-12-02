package keller;

public class K1b extends intZeigerKeller {

    public void dup() {
        int x = pop();
        push(x);
        push(x);
    }

    public void exch() {
        int x = pop();
        int y = pop();
        push(x);
        push(y);
    }
}
