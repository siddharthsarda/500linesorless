package org.aosabook.dagoba.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Graph<T> {
    private List<Vertex> vertices;
    private List<Edge> edges;
    private Map<Integer, Vertex> vertexIndex;
    private int autoId = 1;

    // turns out the graph implementation was of a directed graph,
    // which I guess makes sense for a Graph database.
    private Graph(List<T> vertexValues, List<List<T>> edges) {
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
        this.vertexIndex = new HashMap<Integer, Vertex>();
        addVertices(vertexValues);
        addEdges(edges);
    }

    private void addVertices(List<T> vertexValues) {
        for (T v : vertexValues) {
            addVertex(v);
        }
    }

    private int addVertex(T value) {
        Vertex vertex = new Vertex.Builder()
            .setId(this.autoId++)
            .setValue(value)
            .build();
        this.vertices.add(vertex);
        this.vertexIndex.put(vertex.getId(), vertex);
        return vertex.getId();
    }

    private void addEdges(List<List<T>> edges) {
        //TODO: implement this.
        for (var e : edges) {
            Vertex inVertex = findVertexByValue(e.get(0));
            Vertex outVertex = findVertexByValue(e.get(1));
            addEdge(inVertex.getId(), outVertex.getId());
        }
    }

    private void addEdge(int fromVertexId, int toVertexId) {
        Edge e = Edge.createInstance(findVertexById(fromVertexId), findVertexById(toVertexId));
        e.getInVertex().addInEdge(e);
        e.getOutVertex().addOutEdge(e);
        this.edges.add(e);
    }

    public static <V> Graph<V> newInstance(List<V> vertices, List<List<V>> edges) {
        return new Graph<V>(vertices, edges);
    }

    private Vertex findVertexById(int id) {
        return vertexIndex.get(id);
    }

    private Vertex findVertexByValue(T value) {
        Optional<Vertex> result = this.vertices.stream().filter(v -> v.getValue() == value).findFirst();
        if (result.isPresent()) {
            return result.get();
        }
        return Vertex.getDefaultInstance();
    }
}
