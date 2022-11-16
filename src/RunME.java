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

        int n = 3;
        ArrayList<Heap> heaps = new ArrayList<>();
        for (int i = n; i <= 20; i++) {
            Random r = new Random();
            int[] temp = new int[(int) Math.pow(2, n)];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = r.nextInt(21);
            }
            Heap heap = new Heap(temp.length, temp);
            heaps.add(heap);
        }
        long[] heapSortTimes = new long[heaps.size()];
        for (int i = 0; i < heapSortTimes.length; i++) {
            long startTime = System.nanoTime();
            heapSort(heaps.get(i));
            heapSortTimes[i] = System.nanoTime() - startTime;
        }
        System.out.println(Arrays.toString(heapSortTimes));

    }
}