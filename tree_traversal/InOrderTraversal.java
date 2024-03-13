package tree_traversal;

import recursion.TreeNode;

public class InOrderTraversal {
    public void traverse(TreeNode node) {
        if (node == null) return;
        traverse(node.getLeft());
        System.out.print(node.getValue() + ", ");
        traverse(node.getRight());
    }
}
