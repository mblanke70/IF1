package keller;

public class intArrayKeller implements intKeller {

    private int[] data;
    private int topindex = 0;

    public intArrayKeller() {
        data = new int[100];
        topindex = 0;
    }

    public boolean isEmpty() {
        return topindex == 0;
    }

    public void push(int x) {
        if(topindex==data.length) {
            throw new RuntimeException("Der Keller ist voll!");
        }

        data[topindex] = x;
        topindex++;
    }

    public int peek() {
        if( isEmpty() ) {
            throw new RuntimeException("Der Keller ist leer!");
        }
        return data[topindex-1];
    }

    public int pop() {
        if( isEmpty() ) {
            throw new RuntimeException("Der Keller ist leer!");
        }

        topindex--;
        return data[topindex];
    }

    public String toString() {
        String s = "";

        for(int i=0; i<topindex; i++) {
            s += data[i] + " ";
        }

        return s;
    }

}
