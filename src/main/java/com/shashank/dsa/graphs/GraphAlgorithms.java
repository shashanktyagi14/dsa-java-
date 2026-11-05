package com.shashank.dsa.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public final class GraphAlgorithms {
    private GraphAlgorithms() {
    }

    /**
     * Computes shortest-path distances from source in an unweighted graph.
     * The graph is represented by an adjacency list; unreachable vertices
     * receive distance -1. The graph may be directed or undirected.
     *
     * Time: O(V + E); Space: O(V).
     */
    public static int[] shortestPathDistances(List<List<Integer>> graph, int source) {
        validateGraph(graph);
        int n = graph.size();
        checkVertex(source, n);

        int[] distance = new int[n];
        java.util.Arrays.fill(distance, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        distance[source] = 0;
        queue.add(source);

        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            for (int neighbor : graph.get(vertex)) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[vertex] + 1;
                    queue.add(neighbor);
                }
            }
        }
        return distance;
    }

    /**
     * Returns a deterministic topological ordering of a directed acyclic graph.
     * Among currently available vertices, the smallest index is selected.
     *
     * @throws IllegalStateException if the graph contains a directed cycle
     * Time: O((V + E) log V); Space: O(V).
     */
    public static List<Integer> topologicalSort(List<List<Integer>> graph) {
        validateGraph(graph);
        int n = graph.size();
        int[] indegree = new int[n];

        for (List<Integer> neighbors : graph) {
            for (int neighbor : neighbors) {
                indegree[neighbor]++;
            }
        }

        PriorityQueue<Integer> ready = new PriorityQueue<>();
        for (int vertex = 0; vertex < n; vertex++) {
            if (indegree[vertex] == 0) {
                ready.add(vertex);
            }
        }

        List<Integer> order = new ArrayList<>(n);
        while (!ready.isEmpty()) {
            int vertex = ready.remove();
            order.add(vertex);
            for (int neighbor : graph.get(vertex)) {
                if (--indegree[neighbor] == 0) {
                    ready.add(neighbor);
                }
            }
        }

        if (order.size() != n) {
            throw new IllegalStateException("graph contains a directed cycle");
        }
        return order;
    }

    private static void validateGraph(List<List<Integer>> graph) {
        Objects.requireNonNull(graph, "graph");
        int n = graph.size();
        for (List<Integer> neighbors : graph) {
            Objects.requireNonNull(neighbors, "adjacency list");
            for (Integer neighbor : neighbors) {
                if (neighbor == null || neighbor < 0 || neighbor >= n) {
                    throw new IllegalArgumentException("neighbor index is outside the graph");
                }
            }
        }
    }

    private static void checkVertex(int vertex, int n) {
        if (vertex < 0 || vertex >= n) {
            throw new IllegalArgumentException("source vertex is outside the graph");
        }
    }
}
