package tree_traversal;

import recursion.TreeNode;

public class PreOrderTraversal {
    public void traverse(TreeNode node) {
        if (node == null) return;
        System.out.print(node.getValue() + ", ");
        traverse(node.getLeft());
        traverse(node.getRight());
    }
}
