package org.aosabook.dagoba.graph;

public class Edge {
    private Vertex inVertex;
    private Vertex outVertex;

    private Edge(Vertex inVertex, Vertex outVertex) {
        this.inVertex = inVertex;
        this.outVertex = outVertex;
    }

    public static Edge createInstance(Vertex inVertex, Vertex outVertex) {
        return new Edge(inVertex, outVertex);
    }

    public Vertex getInVertex() {
        return inVertex;
    }

    public Vertex getOutVertex() {
        return outVertex;
    }

}
