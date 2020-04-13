package graph;

import java.util.List;

public class Vertex {
    private int id;
    private int value;
    private List<Edge> inEdges;
    private List<Edge> outEdges;

    public static class Builder {
        private int id = 0;
        private int value = 0;
        private List<Edge> inEdges;
        private List<Edge> outEdges;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setValue(int value) {
            this.value = value;
            return this;
        }

        public Vertex build() {
            return new Vertex(this);
        }
    }

    private Vertex (Vertex.Builder builder) {
        this.id  = builder.id;
        this.value = builder.value;
        this.inEdges = builder.inEdges;
        this.outEdges = builder.outEdges;
    }

    public void addInEdge(Edge e) {
        this.inEdges.add(e);
    }

    public void addOutEdge(Edge e) {
        this.outEdges.add(e);
    }

    public int getId() {
        return id;
    }
}
