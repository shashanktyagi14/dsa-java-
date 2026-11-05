package com.shashank.dsa.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LinkedListAlgorithmsTest {
    @Test
    void reverseRewiresTheExistingNodes() {
        LinkedListAlgorithms.Node first = new LinkedListAlgorithms.Node(1);
        LinkedListAlgorithms.Node second = new LinkedListAlgorithms.Node(2);
        LinkedListAlgorithms.Node third = new LinkedListAlgorithms.Node(3);
        first.next = second;
        second.next = third;

        LinkedListAlgorithms.Node head = LinkedListAlgorithms.reverse(first);

        assertSame(third, head);
        assertSame(second, head.next);
        assertSame(first, head.next.next);
        assertNull(first.next);
    }

    @Test
    void cycleDetectionHandlesSelfLoopAndAcyclicList() {
        LinkedListAlgorithms.Node node = new LinkedListAlgorithms.Node(1);
        assertFalse(LinkedListAlgorithms.hasCycle(node));
        node.next = node;
        assertTrue(LinkedListAlgorithms.hasCycle(node));
    }

    @Test
    void middleNodeReturnsSecondMiddleForEvenLength() {
        LinkedListAlgorithms.Node first = new LinkedListAlgorithms.Node(1);
        LinkedListAlgorithms.Node second = new LinkedListAlgorithms.Node(2);
        LinkedListAlgorithms.Node third = new LinkedListAlgorithms.Node(3);
        LinkedListAlgorithms.Node fourth = new LinkedListAlgorithms.Node(4);
        first.next = second;
        second.next = third;
        third.next = fourth;

        assertSame(third, LinkedListAlgorithms.middleNode(first));
        assertEquals(0, LinkedListAlgorithms.middleNode(null) == null ? 0 : 1);
    }
}
