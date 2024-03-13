package hashtables;
import java.util.ArrayList;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    class Node {
        String key;
        int value;
        Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        dataMap = new Node[size];
    }

    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);

        Node head = dataMap[index];
        dataMap[index] = addNode(head, newNode);
    }

    public Integer get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];

        while (temp != null) {
            if (temp.key == key) return temp.value;
            temp = temp.next;
        }

        return null;
    }

    public ArrayList<String> keys() {
        ArrayList<String> keys = new ArrayList<>();

        for (Node node : dataMap) {
            while (node != null) {
                keys.add(node.key);
                node = node.next;
            }
        }

        return keys;
    }

    private Node addNode(Node head, Node newNode) {
        if (head == null) {
            return newNode;
        }

        Node current = head;

        while(current.next != null && current.key != newNode.key) {
            current = current.next;
        }

        if (current.key == newNode.key) {
            current.value = newNode.value;
            return head;
        }

        current.next = newNode;
        return head;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println("index: " + i);
            Node current = dataMap[i];

            while (current != null) {
                System.out.println("{key: " + current.key + ", value: " + current.value + "}");
                current = current.next;
            }
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();

        for (int asciiValue : keyChars) {
            hash = (hash + asciiValue * 23) % dataMap.length;
        }

        return hash;
    }
}