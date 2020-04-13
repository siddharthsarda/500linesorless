package graph;

public class Edge {
    private Vertex inVertex;
    private Vertex outVertex;

    private Edge(Vertex fromVertex, Vertex toVertex) {
        this.inVertex = fromVertex;
        this.outVertex = toVertex;
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
