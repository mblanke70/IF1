package schlange;

public class intArraySchlange implements intSchlange {
    private int[] data;
    private int first;
    private int last;
    private int N;

    public intArraySchlange(int n) {
        data = new int[n];
        first = 0;
        last = 0;
        N = 0;
    }

    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }
    public int head() {
        if (isEmpty()) throw new RuntimeException();
        return data[first];
    }
    public int dequeue() {
        if (isEmpty()) throw new RuntimeException();
        int item = data[first];
        N--;
        first++; if (first == data.length) first = 0;
        return item;
    }
    public void enqueue(int x) {
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