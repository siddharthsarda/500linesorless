package org.aosabook.dagoba.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
    private int id;
    private T value;
    private List<Edge> inEdges;
    private List<Edge> outEdges;

    public static class Builder<T> {
        private int id = 0;
        private T value;
        private List<Edge> inEdges = new ArrayList<>();
        private List<Edge> outEdges = new ArrayList<>();

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setValue(T value) {
            this.value = value;
            return this;
        }

        public Vertex build() {
            return new Vertex(this);
        }
    }

    private Vertex (Vertex.Builder<T> builder) {
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
        return this.id;
    }

    public T getValue() {
        return this.value;
    }

    public static Vertex getDefaultInstance() {
        return new Vertex.Builder().build();
    }
}
