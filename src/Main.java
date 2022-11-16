public class Main {
    public static void main(String[] args) {
        Heap tester = new Heap(4);
        tester.insert(2);
        tester.insert(7);
        tester.insert(1);
        tester.insert(5);
        System.out.println(tester);
        tester.heapSort();
        System.out.println(tester);
        System.out.println();

        Heap A = new Heap(10, "10 9 8 7 6 5 4 3 2 1");
        System.out.println(A);
        A.heapSort();
        System.out.println(A);
    }
}