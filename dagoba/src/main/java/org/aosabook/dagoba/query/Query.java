package org.aosabook.dagoba.query;

import java.util.ArrayList;
import org.aosabook.dagoba.graph.Graph;

public class Query<T> {

    private Graph<T> graph;
    // A program is a series of steps. Each step is like a pipe in a pipeline—a piece of data comes in one end,
    // is transformed in some fashion, and goes out the other end.
    // Our pipeline doesn't quite work like that, but it's a good first approximation.
    // private ArrayList<T?> program;

    // Each step in our program can have state, and query.state is a list of
    // per-step states that index correlates with the list of steps in query.program.
    // private ArrayList<T?> state;

    // A gremlin is a creature that travels through the graph doing our bidding
    // private ArrayList<T?> gremlin;
}
