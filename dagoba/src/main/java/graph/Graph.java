package graph;

import java.util.HashMap;
import java.util.List;
import org.javatuples.Pair;

public class Graph {
    private  List<Vertex> vertices;
    private  List<Edge> edges;
    private HashMap<Integer, Vertex> vertexIndex;
    private int autoId = 1;

    // turns out the graph implementation was of a directed graph,
    // which I guess makes sense for a Graph database.
    private Graph(List<Integer> vertexValues, List<Pair<Integer, Integer>> edges) {
         addVertices(vertexValues);
         addEdges(edges);
    }

    private void addVertices (List<Integer> vertexValues) {
        for (int v: vertexValues) {
            addVertex(v);
        }
    }

    private int addVertex(int value) {
        Vertex vertex = new Vertex.Builder()
            .setId(this.autoId++)
            .setValue(value)
            .build();
        this.vertices.add(vertex);
        this.vertexIndex.put(vertex.getId(), vertex);
        return vertex.getId();
    }

    private void addEdges (List<Pair<Integer, Integer>> edges) {
        //TODO: implement this.
    }

    private void addEdge(int fromVertexId, int toVertexId) {
        Edge e = Edge.createInstance(findVertexById(fromVertexId), findVertexById(toVertexId));
        e.getInVertex().addInEdge(e);
        e.getOutVertex().addOutEdge(e);
        this.edges.add(e);
    }

    public static Graph newInstance(List<Integer> vertices, List<Pair<Integer, Integer>> edges) {
        return new Graph(vertices, edges);
    }

    private Vertex findVertexById(int id) {
        return vertexIndex.get(id);
    }
}
