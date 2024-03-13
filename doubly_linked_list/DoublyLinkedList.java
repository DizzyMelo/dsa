package doubly_linked_list;

public class DoublyLinkedList {
    Node head;
    Node tail;
    int length;

    class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int value) {
        Node node = new Node(value);

        if (length == 0) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }

        if (length == 1) {
            head = null;
            tail = null;
            length--;
            return null;
        }

        Node nodeToRemove = tail;
        tail = tail.prev;
        tail.next = null;
        nodeToRemove.prev = null;
        length--;

        return nodeToRemove;
    }

    public Node removeFirst() {
        if (length == 0)
            return null;

        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }

        length--;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        int mid = length / 2;

        if (index < mid)
            return getFromHead(index);
        else
            return getFromTail(index);
    }

    public boolean set(int index, int value) {
        Node temp = get(index);

        if (temp == null) {
            return false;
        }

        temp.value = value;
        return true;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length)
            return false;

        if (index == 0) {
            prepend(value);
            return true;
        }
        
        if (index == length) {
            append(value);
            return true;
        }

        Node prev = get(index - 1);
        Node next = prev.next;
        Node newNode = new Node(value);
        
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = next;
        next.prev = newNode;

        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == length - 1) {
            return removeLast();
        }

        Node nodeToRemove = get(index);
        Node prev = nodeToRemove.prev;
        Node next = nodeToRemove.next;

        prev.next = next;
        next.prev = prev;
        nodeToRemove.next = null;
        nodeToRemove.prev = null;

        return nodeToRemove;
    }

    private Node getFromHead(int index) {
        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    private Node getFromTail(int index) {
        Node temp = tail;

        for (int i = length - 1; i > index; i--) {
            temp = temp.prev;
        }

        return temp;
    }

    public void printList() {
        Node current = head;

        while (current != null) {
            if (current.next != null) {
                System.out.print(current.value + " <-> ");
            } else {
                System.out.println(current.value);
            }
            current = current.next;
        }
    }

    public void getDetails() {
        if (length == 0) {
            System.out.println("empty list");
            return;
        }
        System.out.println("Head: " + head.value);
        System.out.println("Tail: " + tail.value);
        System.out.println("Length: " + length);
    }
}
