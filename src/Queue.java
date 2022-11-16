import java.util.Scanner;

public class Queue extends LinkedList {
    private LinkedList<Integer> list;
    private final int maxSize;

    public Queue() {
        this.list = new LinkedList<>();
        this.maxSize = 30;
    }

    public Queue(int size) {
        this.maxSize = size;
        list = new LinkedList<>();
    }

    public Queue(String str) {
        this.maxSize = 30;
        list = new LinkedList<>();
        Scanner scnr = new Scanner(str);
        while (scnr.hasNext()) {
            list.addLast(scnr.nextInt());
        }
    }

    public Queue(String str, int size) {
        this.maxSize = size;
        list = new LinkedList<>();
        Scanner scnr = new Scanner(str);
        while (scnr.hasNext()) {
            if (size() == 0) list.addFirst(scnr.nextInt());
            else list.addLast(scnr.nextInt());
        }
    }

    public void enqueue(int n) {
        list.addLast(n);
    }

    public int dequeue() {
        int DQ = 0;
        try {
            DQ = list.removeFirst();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return DQ;
    }

    public int front() {
        return list.getFirst();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public Object removeFirst() throws Exception {
        return dequeue();
    }

}
