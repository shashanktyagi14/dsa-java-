package com.shashank.dsa.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class BinaryTreeAlgorithmsTest {
    @Test
    void depthAndLevelOrderHandleEmptyAndNonEmptyTrees() {
        assertEquals(0, BinaryTreeAlgorithms.maximumDepth(null));
        assertEquals(List.of(), BinaryTreeAlgorithms.levelOrder(null));

        BinaryTreeAlgorithms.Node root = new BinaryTreeAlgorithms.Node(3);
        root.left = new BinaryTreeAlgorithms.Node(9);
        root.right = new BinaryTreeAlgorithms.Node(20);
        root.right.left = new BinaryTreeAlgorithms.Node(15);
        root.right.right = new BinaryTreeAlgorithms.Node(7);

        assertEquals(3, BinaryTreeAlgorithms.maximumDepth(root));
        assertEquals(List.of(List.of(3), List.of(9, 20), List.of(15, 7)),
                BinaryTreeAlgorithms.levelOrder(root));
    }

    @Test
    void maximumDepthHandlesDeepSkewedTreesWithoutRecursion() {
        BinaryTreeAlgorithms.Node root = new BinaryTreeAlgorithms.Node(0);
        BinaryTreeAlgorithms.Node current = root;
        int nodeCount = 50_000;

        for (int i = 1; i < nodeCount; i++) {
            current.right = new BinaryTreeAlgorithms.Node(i);
            current = current.right;
        }

        assertEquals(nodeCount, BinaryTreeAlgorithms.maximumDepth(root));
    }

    @Test
    void validatesStrictBstOrderingIncludingIntegerExtremes() {
        BinaryTreeAlgorithms.Node root = new BinaryTreeAlgorithms.Node(0);
        root.left = new BinaryTreeAlgorithms.Node(Integer.MIN_VALUE);
        root.right = new BinaryTreeAlgorithms.Node(Integer.MAX_VALUE);
        assertTrue(BinaryTreeAlgorithms.isValidBst(root));

        root.right.left = new BinaryTreeAlgorithms.Node(0);
        assertFalse(BinaryTreeAlgorithms.isValidBst(root));
    }
}
