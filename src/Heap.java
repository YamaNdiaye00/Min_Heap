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
            H[size] = scnr.nextInt();
            size++;
        }
    }

    public void heapify(int index) {
        if (index > size / 2) {
            int temp = index;

            if (getRightChildIndex(index) <= size)
                temp = H[getLeftChildIndex(index)] < H[getRightChildIndex(index)] ? getLeftChildIndex(index) : getRightChildIndex(index);
            else
                temp = H[getLeftChildIndex(index)];

            if (H[index] > H[getLeftChildIndex(index)] || H[index] > H[getLeftChildIndex(index)]) {
                swap(index, temp);
                heapify(temp);
            }

        }
    }

    public int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public int getLeftChildIndex(int parentIndex) {
        return (parentIndex * 2) + 1;
    }

    public int getRightChildIndex(int parentIndex) {
        return (parentIndex * 2) + 2;
    }

    public void swap(int a, int b) {
        int temp = H[a];
        H[a] = H[b];
        H[b] = temp;
    }


    public void heapSort() {
        int index = size - 1;
        while (getParentIndex(index) >= 0 && H[getParentIndex(index)] > H[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void downHeap() {
        int index = 0;
        while (getLeftChildIndex(index) < size) {
            int childIndex = getLeftChildIndex(index);
            if (getRightChildIndex(index) < size && H[getRightChildIndex(index)] < H[getLeftChildIndex(index)])
                childIndex = getRightChildIndex(index);
            if (H[index] < H[childIndex]) break;
            else swap(index, childIndex);
            index = childIndex;
        }
    }

    public void insert(int n) {
        try {
            if (size >= maxSize) throw new IndexOutOfBoundsException("Heap is full");
            H[size] = n;
            size++;
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeMin() {
        try {
            if (size <= 0) throw new Exception("Heap is empty");
            H[0] = H[size - 1];
            size--;
            if (size > 0) downHeap();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int min() {
        try {
            if (size <= 0) throw new Exception("Heap is empty");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return H[0];
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
