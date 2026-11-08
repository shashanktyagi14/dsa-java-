package com.shashank.dsa.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public final class BinaryTreeAlgorithms {
    private BinaryTreeAlgorithms() {
    }

    public static final class Node {
        public final int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * Returns the number of nodes on the longest root-to-leaf path.
     * An empty tree has depth zero. The input must be an acyclic binary tree.
     * Iterative breadth-first traversal avoids recursion-depth failures on
     * highly skewed trees.
     * Time: O(n); Space: O(w), where w is the maximum tree width.
     */
    public static int maximumDepth(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    /**
     * Returns the values grouped by level, from root to leaves.
     * The input must be an acyclic binary tree.
     * Time: O(n); Space: O(n).
     */
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.remove();
                level.add(node.value);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            levels.add(level);
        }
        return levels;
    }

    /**
     * Validates the strict binary-search-tree ordering (left < node < right).
     * Duplicate values are not allowed.
     * Time: O(n); Space: O(h).
     */
    public static boolean isValidBst(Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        Node current = root;
        long previous = Long.MIN_VALUE;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (current.value <= previous) {
                return false;
            }
            previous = current.value;
            current = current.right;
        }
        return true;
    }
}
