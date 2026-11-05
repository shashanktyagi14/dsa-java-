package com.shashank.dsa.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class GraphAlgorithmsTest {
    @Test
    void shortestPathDistancesMarkUnreachableVertices() {
        List<List<Integer>> graph = List.of(
                List.of(1, 2),
                List.of(0, 3),
                List.of(0),
                List.of(1),
                List.of()
        );
        assertEquals(List.of(0, 1, 1, 2, -1),
                java.util.Arrays.stream(GraphAlgorithms.shortestPathDistances(graph, 0))
                        .boxed().toList());
    }

    @Test
    void topologicalSortRespectsEveryEdge() {
        List<List<Integer>> graph = List.of(
                List.of(2, 3),
                List.of(3),
                List.of(4),
                List.of(4),
                List.of()
        );
        List<Integer> order = GraphAlgorithms.topologicalSort(graph);
        int[] position = new int[order.size()];
        for (int i = 0; i < order.size(); i++) {
            position[order.get(i)] = i;
        }
        for (int from = 0; from < graph.size(); from++) {
            for (int to : graph.get(from)) {
                org.junit.jupiter.api.Assertions.assertTrue(position[from] < position[to]);
            }
        }
    }

    @Test
    void topologicalSortRejectsCycles() {
        assertThrows(IllegalStateException.class,
                () -> GraphAlgorithms.topologicalSort(List.of(List.of(1), List.of(0))));
    }

    @Test
    void graphMethodsRejectInvalidVertices() {
        assertThrows(IllegalArgumentException.class,
                () -> GraphAlgorithms.shortestPathDistances(List.of(List.of()), 1));
        assertThrows(IllegalArgumentException.class,
                () -> GraphAlgorithms.topologicalSort(List.of(List.of(1))));
    }
}
