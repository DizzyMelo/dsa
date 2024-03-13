package stacks;

public class Stack {
    private Node top;
    private int height = 0;

    public Stack(int value) {
        Node node = new Node(value);
        top = node;
        height = 1;
    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void push(int value) {
        Node newNode = new Node(value);

        if (height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }

        height++;
    }

    public Node pop() {
        if (top == null) return null;

        Node temp = top;
        top = top.next;
        temp.next = null;

        height--;
        return temp;
    }

    public void printStack() {
        Node current = top;

        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public void printStackDetails() {
        if (top != null) {
            System.out.println("Top: " + top.value);
        }
        System.out.println("Height: " + height);
    }
}
