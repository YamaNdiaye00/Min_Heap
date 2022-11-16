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

    public Heap(int n, int[] arr) {
        H = new int[n];
        size = 0;
        maxSize = n;
        for (int i : arr) {
            insert(i);
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

    /*
    Function starts at the index of the last element in the array
    The condition in the while loop checks whether that element has a parent and if the value at the parent is superior
    If it is, a swap O(1) occurs.
    Worst case scenario, the element keeps on climbing the heap till it swaps elements with the root,
    Maximum travel is log(n) which is the height of the heap
     */
    public void upHeap() {
        int index = size - 1;
        while (hasParent(index) && H[getParentIndex(index)] > H[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    /*
    Function starts at the index of the first element in the array, so 0
    Heaps span from left to right on each level, so the while loop checks if the element has a child on the leftside
    if the element is greater than its child, a swap occurs
    Worst case scenario is when the element initially on top keeps swapping until it reaches the bottom of the heap,
    since the height is log(n), the function runs log(n) too
    O(log(n))

     */
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

    /*
    IF array is full
        Do nothing
    SET n as last element in array
    increment size of array
    index <- size - 1 = index of inserted element
    WHILE element at index has ancestors AND ancestors greater than said element
        swap element with ancestor
        index <- index of ancestor
     */

    /*
    4 O(1) operations, 4
    upHeap() is O(log n)
    O(n) is log(n) + 4
    Time Complexity is O(log(n))
     */
    public void insert(int n) {
        if (size >= maxSize) {
            return;
        }
        H[size] = n;
        size++;
        upHeap();
    }

    /*
    IF array is empty
        return 0;
    popped <- element at top
    element at the top <- last element
    decrement size
    index <- top element
    WHILE element has descendants
        child <- index of left child
        IF element has right child AND right child value inferior to left side child
            child <- index of right child (smaller)
        IF element is inferior to child element
            break
        ELSE
            swap
        index <- child
     */

    /*
    5 O(1) operations, 5
    downHeap() is O(log n)
    O(n) is log(n) + 3
    Time Complexity is O(log(n))
     */
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
