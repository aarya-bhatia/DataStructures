package com.aarya.graphs.pathfinding;

public class Edge {

    private final int node;
    private final float dist;

    public Edge(int u, float f) {
        node = u;
        dist = f;
    }

    public int getNode(){ return node; }

    public float getDist() { return dist; }

}
