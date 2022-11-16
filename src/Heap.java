import java.util.Scanner;

public class Heap {

    private final int[] H;
    private final int maxSize;
    private int size;


    public Heap(int n) {
        H = new int[n];
        size = 0;
        maxSize = n;
    }

    public Heap(int n, String str) {
        H = new int[n];
        size = 0;
        maxSize = n;
        Scanner scnr = new Scanner(str);
        while (scnr.hasNext()) {
            insert(scnr.nextInt());
        }
    }


    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public int getLeftChildIndex(int index) {
        return (index * 2) + 1;
    }

    public int getRightChildIndex(int index) {
        return (index * 2) + 2;
    }

    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    public boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    public void swap(int a, int b) {
        int temp = H[a];
        H[a] = H[b];
        H[b] = temp;
    }

    public void upHeap() {
        int index = size - 1;
        while (hasParent(index) && H[getParentIndex(index)] > H[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void downHeap() {
        int index = 0;
        while (hasLeftChild(index)) {
            int child = getLeftChildIndex(index);
            if (hasRightChild(index) && H[getRightChildIndex(index)] < H[getLeftChildIndex(index)]) {
                child = getRightChildIndex(index);
            }
            if (H[index] < H[child]) break;
            else swap(index, child);
            index = child;
        }
    }

    public void insert(int n) {
        if (size >= maxSize) {
            return;
        }
        H[size] = n;
        size++;
        upHeap();
    }

    public int removeMin() {
        if (size == 0) return 0;
        int popped = H[0];
        H[0] = H[size - 1];
        size--;
        downHeap();
        return popped;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (size == 0) return "Heap is empty";
        String str = "";
        for (int i = 0; i < size; i++) {
            str += H[i] + "\t";
        }
        return str;
    }
}
