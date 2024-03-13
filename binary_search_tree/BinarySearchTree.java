package binary_search_tree;

public class BinarySearchTree {
    private Node root;

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value) {
        // boolean treeContainsNode = contains(value);
        // if (treeContainsNode) return false;

        // root = insertRecursively(root, value);
        // return true;

        return insertIteratively(value);
    }

    private Node insertRecursively(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRecursively(root.left, value);
        } else if (value > root.value) {
            root.right = insertRecursively(root.right, value);
        } else {
            return null;
        }

        return root;
    }

    private boolean insertIteratively(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return true;
        }

        Node temp = root;

        while (true) {
            if (node.value == temp.value) return false;

            if (node.value < temp.value) {
                if (temp.left == null) {
                    temp.left = node;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = node;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        return containsIteratively(value);
    }

    private boolean containsRecursively(Node node, int value) {
        if (node == null) return false;

        if (node.value == value) return true;

        return containsRecursively(node.left, value) || containsRecursively(node.right, value);
    }

    private boolean containsIteratively(int value) {
        Node temp = root;
        while(temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public void printTree(Node root, String sufix) {
        if (root == null) {
            return;
        }

        printTree(root.left, "L");
        System.out.println(sufix + ": " + root.value);
        printTree(root.right, "R");
    }

    public Node getRoot() {
        return root;
    }
}
