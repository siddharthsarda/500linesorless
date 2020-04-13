package org.aosabook.dagoba;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.aosabook.dagoba.graph.Graph;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GraphTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void graphCreationTest() {
        getTestGraph();
        assertTrue(true);

    }

    private Graph<Integer> getTestGraph() {
        List<Integer> vertices = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        List<List<Integer>> edges = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(1, 3),
            Arrays.asList(2, 4),
            Arrays.asList(2, 5),
            Arrays.asList(3, 6),
            Arrays.asList(3, 7),
            Arrays.asList(4, 8),
            Arrays.asList(4, 9),
            Arrays.asList(5, 10),
            Arrays.asList(5, 11),
            Arrays.asList(6, 12),
            Arrays.asList(6, 13),
            Arrays.asList(7, 14),
            Arrays.asList(7, 15)
        );
        Graph.newInstance(vertices, edges);
        return null;
    }
}


