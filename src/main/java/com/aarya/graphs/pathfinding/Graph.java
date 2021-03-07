package com.aarya.graphs.pathfinding;

import java.util.ArrayList;
import java.util.List;

/**
 * This represents a weighted graph
 */
public class Graph {

    protected final List<Edge>[] edges;
    protected final int size;

    public Graph(int n) {
        this.size = n;
        this.edges = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            this.edges[i] = new ArrayList<>();
        }
    }

    public int size() {
        return this.size;
    }

    public List<Edge> getLinkedNodes(int u) {
        if(isValid(u)) {
            return this.edges[u];
        }
        return null;
    }

    public void addEdge(int u, int v, float dist) {
        if (!isValid(u) || !isValid(v)) {
            return;
        }
        this.edges[u].add(new Edge(v, dist));
        this.edges[v].add(new Edge(u, dist));
    }

    public void show() {
        System.out.println("Printing Graph");
        for(int i = 0; i < size; i++) {
            System.out.printf("Node %d -> ", i);
            for(Edge e: edges[i]) {
                System.out.printf("[Node %d, Dist %.1f]\t", e.getNode(), e.getDist());
            }
            System.out.println();
        }
    }

    public boolean isValid(int u) {
        return u >= 0 && u < size();
    }
}