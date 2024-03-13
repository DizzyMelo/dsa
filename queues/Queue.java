package queues;

public class Queue {
    private Node first;
    private Node last;
    private int size;

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Queue(int value) {
        Node newNode = new Node(value);

        first = newNode;
        last = newNode;
        size = 1;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (size == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }

        size++;
    }

    public Node dequeue() {
        if (size == 0)
            return null;

        Node temp = first;

        if (size == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            temp.next = null;
        }

        size--;
        return temp;
    }

    public void printQueue() {
        Node current = first;

        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}
