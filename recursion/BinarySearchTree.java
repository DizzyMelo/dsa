package recursion;

public class BinarySearchTree {
    private TreeNode root;

    public boolean contains(int value) {
        return contains(root, value);
    }

    public TreeNode getRoot() {
        return this.root;
    }

    private boolean contains(TreeNode root, int value) {
        if (root == null) return false;
        if (root.value == value) return true;

        if (value < root.value) {
            return contains(root.left, value);
        } else {
            return contains(root.right, value);
        }
    }

    public void insert(int value) {
        this.root = insert(root, value);
    }

    private TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.value) {
            root.left = insert(root.left, value);
        } else if (value > root.value) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public TreeNode delete(int value) {
        return delete(this.root, value);
    }

    private TreeNode delete(TreeNode root, int value) {
        if (root == null) return null;

        if (value < root.value) {
            root.left = delete(root.left, value);
        } else if (value > root.value) {
            root.right = delete(root.right, value);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.right == null) {
                root = root.left;
            } else if (root.left == null) {
                root = root.right;
            } else {
                int minValue = minimumValue(root.right);
                root.value = minValue;
                root.right = delete(root.right, minValue);
            }
        }

        return root;
    }

    public int minimumValue() {
        return minimumValue(this.root);
    }
    private int minimumValue(TreeNode root) {
        if (root == null) return -1;
        if (root.left == null) return root.value;

        return minimumValue(root.left);
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(TreeNode root) {
        if (root == null) return;
        
        System.out.println(root.value);
        
        printTree(root.left);
        printTree(root.right);
    }


}
