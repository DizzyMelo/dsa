package recursion;

public class MainBST {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        System.out.println(bst.contains(10));
        
        bst.insert(10);
        bst.insert(9);
        bst.insert(11);
        bst.insert(0);
        bst.delete(10);
        bst.printTree();

    }
}
