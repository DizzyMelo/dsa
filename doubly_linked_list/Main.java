package doubly_linked_list;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(1);
   
        doublyLinkedList.printList();

        doublyLinkedList.append(2);
        doublyLinkedList.append(3);
        doublyLinkedList.append(4);
        doublyLinkedList.append(5);
        doublyLinkedList.append(6);


        doublyLinkedList.remove(0);
        
        doublyLinkedList.printList();
        
        doublyLinkedList.remove(3); 

        doublyLinkedList.printList();
        doublyLinkedList.getDetails();


    }
}
