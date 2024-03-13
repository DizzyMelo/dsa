package linked_lists;

import java.util.ArrayList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        int i = 0;
        Node current = head;

        while (i < length && i != index) {
            current = current.next;
            i++;
        }

        return current;
    }

    public void preppend(int value) {
        Node newNode = new Node(value);
        Node temp = head;
        head = newNode;
        head.next = temp;
        length++;

        if (length == 1) {
            tail = head;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }

        Node current = head;
        Node pre = head;

        while (current.next != null) {
            pre = current;
            current = current.next;
        }

        tail = pre;
        tail.next = null;
        length--;

        if (length == 0) {
            head = null;
            tail = null;
        }

        return current;
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        }

        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;

        if (length == 0) {
            tail = null;
        }

        return temp;
    }

    public boolean set(int index, int value) {
        Node node = get(index);

        if (node == null) {
            return false;
        }

        node.value = value;
        return true;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }

        if (index == 0) {
            preppend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node current = get(index - 1);

        newNode.next = current.next;
        current.next = newNode;
        length++;

        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length)
            return null;

        if (index == 0) {
            return removeFirst();
        }

        if (index == length - 1) {
            return removeLast();
        }

        Node previousNode = get(index - 1);
        Node nodeToRemove = previousNode.next;

        previousNode.next = nodeToRemove.next;
        nodeToRemove.next = null;
        length--;

        return nodeToRemove;
    }

    public void reverse() {
        Node current = head;
        head = tail;
        tail = current;

        Node previous = null;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
    }

    public void reverse(int start, int end) {
        if (length == 0) return;
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previous = dummyNode;

        for(int i = 0; i < start; i++) {
            previous = previous.next;
        }

        Node currentNode = previous.next;

        for(int i = 0; i < end - start; i++) {
            Node node = currentNode.next;
            currentNode.next = node.next;
            node.next = previous.next;
            previous.next = node;
        }

        head = dummyNode.next;
    }

    public void printList() {
        Node curr = head;
        ArrayList<String> nodes = new ArrayList<>();

        while (curr != null) {
            nodes.add(String.valueOf(curr.value));
            curr = curr.next;
        }

        System.out.println(String.join(" -> ", nodes));
    }

    public void getList() {
        if (length == 0) {
            System.out.println("The list is empty");
            return;
        }
        System.out.println("Head: " + this.head.value);
        System.out.println("Tail: " + this.tail.value);
        System.out.println("Length: " + this.length);
    }

    public int getHeadValue() {
        return head.value;
    }

    public int getTailValue() {
        return tail.value;
    }
}