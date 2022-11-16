public class Main {
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


    }
}