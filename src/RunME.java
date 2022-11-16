import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RunME {

    public static int[] heapSort(Heap heap) {
        int[] arr = new int[heap.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.removeMin();
        }
        return arr;
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void inPlaceQuickSort(int[] S, int a, int b) {
        if (a >= b) return;
        int pivot = S[b];
        int l = a, r = b - 1;
        while (l <= r) {
            while (l <= r && S[l] <= pivot) {
                l++;
            }
            while (l <= r && S[r] >= pivot) {
                r--;
            }
            if (l < r) {
                int temp = S[l];
                S[l] = S[r];
                S[r] = temp;
            }
        }
        int temp = S[l];
        S[l] = S[b];
        S[b] = temp;
        inPlaceQuickSort(S, a, l - 1);
        inPlaceQuickSort(S, l + 1, b);
    }

    public static Queue mergeSort(Queue S) {
        Queue temp = new Queue();
        if (S.size() > 1) {
            ArrayList<Queue> division = partition(S);
            Queue S1 = mergeSort(division.get(0));
            Queue S2 = mergeSort(division.get(1));
            while (S1.size() > 0 && S2.size() > 0) {
                if (S1.front() < S2.front()) temp.enqueue(S1.dequeue());
                else temp.enqueue(S2.dequeue());
            }
            while (S1.size() > 0) {
                temp.enqueue(S1.dequeue());
            }
            while (S2.size() > 0) {
                temp.enqueue(S2.dequeue());
            }
            return temp;
        }
        temp.enqueue(S.dequeue());
        return temp;
    }

    public static ArrayList<Queue> partition(Queue S) {
        ArrayList<Queue> temp = new ArrayList<>();
        int n = S.size();
        Queue left = new Queue();
        Queue right = new Queue();
        for (int i = 0; i < n / 2; i++) {
            left.enqueue(S.dequeue());
        }
        while (S.size() > 0) {
            right.enqueue(S.dequeue());
        }
        temp.add(left);
        temp.add(right);
        return temp;
    }

    public static void main(String[] args) {
        Heap tester = new Heap(7);
        tester.insert(2);
        tester.insert(7);
        tester.insert(1);
        tester.insert(3);
        tester.insert(5);
        tester.insert(6);
        tester.insert(4);
        System.out.println(tester);
        tester.removeMin();
        System.out.println(tester);
        System.out.println();

        int[] A = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] B = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] C = {1, 3, 5, 7, 9, 10, 8, 6, 4, 2};

        System.out.println("Testing for A");
        System.out.println("Initial array: " + Arrays.toString(A));
        Heap Ah = new Heap(A.length, A);
        System.out.println("To minHeap: " + Ah);
        System.out.println("After HeapSort: " + Arrays.toString(heapSort(Ah)));
        System.out.println();

        System.out.println("Testing for B");
        System.out.println("Initial array: " + Arrays.toString(B));
        Heap Bh = new Heap(B.length, B);
        System.out.println("To minHeap: " + Bh);
        System.out.println("After HeapSort: " + Arrays.toString(heapSort(Bh)));
        System.out.println();

        System.out.println("Testing for C");
        System.out.println("Initial array: " + Arrays.toString(A));
        Heap Ch = new Heap(C.length, C);
        System.out.println("To minHeap: " + Ch);
        System.out.println("After HeapSort: " + Arrays.toString(heapSort(Ch)));
        System.out.println();

        int n = 3;
        ArrayList<int[]> arrays = new ArrayList<>();
        for (int i = n; i <= 20; i++) {
            Random r = new Random();
            int[] temp = new int[(int) Math.pow(2, n)];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = r.nextInt(21);
            }
            arrays.add(temp);
        }
        ArrayList<int[]> arrays2 = new ArrayList<>(arrays);
        ArrayList<int[]> arrays3 = new ArrayList<>(arrays);
        ArrayList<int[]> arrays4 = new ArrayList<>(arrays);

        long[] heapSortTimes = new long[arrays.size()];
        for (int i = 0; i < heapSortTimes.length; i++) {
            Heap heap = new Heap(arrays.get(i).length, arrays.get(i));
            long startTime = System.nanoTime();
            heapSort(heap);
            heapSortTimes[i] = System.nanoTime() - startTime;
        }
        System.out.println("Times for Heap-Sort on all arrays");
        System.out.println(Arrays.toString(heapSortTimes));

        long[] insertionSortTimes = new long[arrays.size()];
        for (int i = 0; i < insertionSortTimes.length; i++) {
            long startTime = System.nanoTime();
            insertionSort(arrays2.get(i));
            long duration = System.nanoTime() - startTime;
            insertionSortTimes[i] = duration;
        }

        System.out.println();
        System.out.println("Times for Insertion-Sort on all arrays");
        System.out.println(Arrays.toString(insertionSortTimes));
        System.out.println();

        long[] quickSortTimes = new long[arrays3.size()];
        for (int i = 0; i < quickSortTimes.length; i++) {
            long startTime = System.nanoTime();
            inPlaceQuickSort(arrays3.get(i), 0, arrays3.get(i).length - 1);
            long duration = System.nanoTime() - startTime;
            quickSortTimes[i] = duration;
        }
        System.out.println("Times for Quick-Sort on all arrays");
        System.out.println(Arrays.toString(quickSortTimes));
        System.out.println();

        ArrayList<Queue> queues = new ArrayList<Queue>();
        for (int[] i : arrays4) {
            Queue temp = new Queue();
            for (int j : i) {
                temp.enqueue(j);
            }
            queues.add(temp);
        }
        long[] mergeSortTimes = new long[queues.size()];
        for (int i = 0; i < mergeSortTimes.length; i++) {
            long startTime = System.nanoTime();
            mergeSort(queues.get(i));
            long duration = System.nanoTime() - startTime;
            mergeSortTimes[i] = duration;
        }
        System.out.println("Times for Merge-Sort on all arrays");
        System.out.println(Arrays.toString(mergeSortTimes));
        System.out.println();

    }
}