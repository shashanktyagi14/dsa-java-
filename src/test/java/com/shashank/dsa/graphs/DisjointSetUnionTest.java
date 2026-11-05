package com.shashank.dsa.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DisjointSetUnionTest {
    @Test
    void unionTracksComponentsAndSizes() {
        DisjointSetUnion dsu = new DisjointSetUnion(5);
        assertTrue(dsu.union(0, 1));
        assertTrue(dsu.union(1, 2));
        assertFalse(dsu.union(0, 2));
        assertTrue(dsu.connected(0, 2));
        assertFalse(dsu.connected(0, 4));
        assertEquals(3, dsu.componentSize(1));
        assertEquals(3, dsu.components());
    }

    @Test
    void findValidatesIndices() {
        DisjointSetUnion dsu = new DisjointSetUnion(0);
        assertThrows(IndexOutOfBoundsException.class, () -> dsu.find(0));
        assertThrows(IllegalArgumentException.class, () -> new DisjointSetUnion(-1));
    }
}
