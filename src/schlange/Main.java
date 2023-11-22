package schlange;

public class Main {
    public static void main(String[] argv) {
        intSchlange s = new intArraySchlange(10);
        s.enqueue(1);
        s.enqueue(2);
        s.enqueue(3);
        System.out.println(s);
        s.dequeue();
        System.out.println(s);
        s.enqueue(4);
        System.out.println(s);
        System.out.println(s.head());
        s.dequeue();
        s.dequeue();
        s.dequeue();
        System.out.println(s.isEmpty());
    }
}
