package binary_search_tree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(0);
        tree.insert(3);
        tree.insert(4);
        tree.insert(8);
        tree.insert(12);
        tree.insert(79);
        tree.insert(-79);

        tree.printTree(tree.getRoot(), "ROOT");

        System.out.println(tree.contains(12));
        System.out.println(tree.contains(1));
        System.out.println(tree.contains(2));
        System.out.println(tree.contains(20));
        System.out.println(tree.contains(8));
        System.out.println(tree.contains(80));
    }
}
