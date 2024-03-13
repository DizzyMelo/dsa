package tree_traversal;

import recursion.*;

public class Main {
    private static BinarySearchTree tree = new BinarySearchTree();
    public static void main(String[] args) {
        tree.insert(47);
        tree.insert(21);
        tree.insert(76);
        tree.insert(18);
        tree.insert(27);
        tree.insert(52);
        tree.insert(82);

        //             47
        //      21           76
        //   18     27    52     82
    
        BFS bfs = new BFS(tree);
        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
        PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
        InOrderTraversal inOrderTraversal = new InOrderTraversal();

        TreeValidator treeValidator = new TreeValidator();

        // preOrderTraversal.traverse(tree.getRoot());

        // System.out.println();

        // postOrderTraversal.traverse(tree.getRoot());

        // System.out.println();

        
        inOrderTraversal.traverse(tree.getRoot());

        System.out.println();

        boolean value = treeValidator.isValidBST(tree.getRoot());

        System.out.println(value);

        // bfs.breadthFirstSearch();
    }
}
