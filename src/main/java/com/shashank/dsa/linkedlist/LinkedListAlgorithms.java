package com.shashank.dsa.linkedlist;

public final class LinkedListAlgorithms {
    private LinkedListAlgorithms() {
    }

    public static final class Node {
        public final int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * Reverses a singly linked list in place and returns its new head.
     * Time: O(n); Space: O(1).
     */
    public static Node reverse(Node head) {
        Node previous = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    /**
     * Detects a cycle using Floyd's tortoise-and-hare algorithm.
     * Time: O(n); Space: O(1).
     */
    public static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the middle node. For an even number of nodes, returns the
     * second of the two middle nodes.
     * Time: O(n); Space: O(1).
     */
    public static Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
