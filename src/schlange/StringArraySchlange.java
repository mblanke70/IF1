package schlange;

public class StringArraySchlange implements StringSchlange {
    private String[] data;
    private int first;
    private int last;
    private int N;

    public StringArraySchlange(int n) {
        data = new String[n];
        first = 0;
        last = 0;
        N = 0;
    }

    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }
    public String head() {
        if (isEmpty()) throw new RuntimeException();
        return data[first];
    }
    public String dequeue() {
        if (isEmpty()) throw new RuntimeException();
        String item = data[first];
        N--;
        first++; if (first == data.length) first = 0;
        return item;
    }
    public void enqueue(String x) {
        if(N == data.length) throw new RuntimeException();
        data[last] = x;
        last++; if (last == data.length) last = 0;
        N++;
    }
    public String toString() {
        String s = "";
        int c = first;
        for(int i = 0; i < N; i++) {
            s += data[c] + " ";
            c = (c+1) % data.length;
        }
        return s;
    }
}