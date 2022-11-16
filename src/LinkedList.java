public class LinkedList<T> {
    private Node head;

    public class Node {
        // Instance variables:
        private T element;
        private Node next;

        // Creates a node with null ref to its elem and next node.
        public Node() {
            this(null, null);
        }

        // Creates a node with the given element and next node.
        public Node(T e, Node n) {
            element = e;
            next = n;
        }

        // Accessor methods
        public T getElement() {
            return element;
        }

        public Node getNext() {
            return next;
        }

        // Update methods
        public void setElement(T newElem) {
            element = newElem;
        }

        public void setNext(Node newNext) {
            next = newNext;
        }
    }


    public LinkedList() {
        head = new Node();
    }

    public void addFirst(T element) {
        Node v = new Node(element, null);
        if (head.element != null) v.setNext(head);
        head = v;
    }

    public T removeFirst() throws Exception {
        if (head.element == null) throw new Exception("Empty list");
        else {
            Node t = head;
            if (head.next != null) head = head.next;
            else head = new Node();
            return t.element;
        }
    }

    public void addLast(T element) {
        if (head.element == null) {
            head.setElement(element);
        } else {
            Node v = new Node(element, null);
            Node tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.setNext(v);
        }
    }

    public T removeLast() {
        Node secondToLast = head;
        while (secondToLast.next.next != null) {
            secondToLast = secondToLast.next;
        }
        T element = secondToLast.next.element;
        secondToLast.setNext(null);
        return element;
    }

    public T getFirst() {
        return head.element;
    }

    public T getLast() {
        Node h = head;
        while (h.next != null) {
            h = h.next;
        }
        return h.element;
    }

    public int size() {
        if (head == null || head.element == null) return 0;

        int count = 1;
        Node h = head;
        while (h.next != null) {
            h = h.next;
            count++;
        }
        return count;
    }
}
