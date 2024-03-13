package tree_traversal;

import recursion.TreeNode;

public class TreeValidator {

    public boolean isValidBST(TreeNode node) {
        return isValidBST(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long minValue, long maxValue) {
        if (node == null)
            return true;

        if (!(minValue < node.getValue() && maxValue > node.getValue()))
            return false;

        return isValidBST(node.getLeft(), minValue, node.getValue())
                && isValidBST(node.getRight(), node.getValue(), maxValue);
    }
}

//            47
//     21             76
//  18    27      52     82