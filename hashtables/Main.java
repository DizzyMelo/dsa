package hashtables;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.set("nails", 100);
        hashTable.set("tile", 50);
        hashTable.set("lumber", 80);
        hashTable.set("nails", 200);

        hashTable.print();

        System.out.println(hashTable.keys());
    }
}
