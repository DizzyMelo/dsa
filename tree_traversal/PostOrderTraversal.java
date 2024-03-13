package tree_traversal;

import recursion.TreeNode;

public class PostOrderTraversal {
    public void traverse(TreeNode node) {
        if (node == null) return;
        traverse(node.getLeft());
        traverse(node.getRight());
        System.out.print(node.getValue() + ", ");
    }
}
