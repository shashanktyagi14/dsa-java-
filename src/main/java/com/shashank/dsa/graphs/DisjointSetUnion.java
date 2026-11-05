package com.shashank.dsa.graphs;

public final class DisjointSetUnion {
    private final int[] parent;
    private final int[] size;
    private int components;

    /**
     * Creates n disjoint singleton sets indexed from 0 to n - 1.
     * @throws IllegalArgumentException if n is negative
     */
    public DisjointSetUnion(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        parent = new int[n];
        size = new int[n];
        components = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    /**
     * Returns the representative of x, applying path compression.
     * Time: amortized O(alpha(n)).
     */
    public int find(int x) {
        checkElement(x);
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    /**
     * Merges the sets containing a and b. Returns true only if a merge occurred.
     * Uses union by size and path compression; amortized O(alpha(n)).
     */
    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return false;
        }
        if (size[rootA] < size[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }
        parent[rootB] = rootA;
        size[rootA] += size[rootB];
        components--;
        return true;
    }

    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }

    public int componentSize(int x) {
        return size[find(x)];
    }

    public int components() {
        return components;
    }

    private void checkElement(int x) {
        if (x < 0 || x >= parent.length) {
            throw new IndexOutOfBoundsException("element index: " + x);
        }
    }
}
