package tree_traversal;

import recursion.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class BFS {
    private BinarySearchTree tree;
    
    public BFS(BinarySearchTree tree) {
        this.tree = tree;
    }

    public List<Integer> breadthFirstSearch() {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.add(tree.getRoot());

        while(!deque.isEmpty()) {
            TreeNode current = deque.pollLast();

            result.add(current.getValue());

            if (current.getLeft() != null) {
                deque.addFirst(current.getLeft());
            }

            if (current.getRight() != null) {
                deque.addFirst(current.getRight());
            }
        }

        result.forEach(value -> System.out.print(value + ", "));


        return result;
    }
}
