package com.aarya.graphs.pathfinding;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPath {

    protected static boolean DEBUG_FLAG;
    protected final Graph graph;
    protected final PriorityQueue<Integer> q;
    protected final Boolean[] visited;
    protected final Integer[] prev;
    protected final Float[] dist;
    protected final int size;

    public ShortestPath(Graph graph, boolean b) {
        DEBUG_FLAG = b;

        this.size = graph.size();
        this.q = new PriorityQueue<>(size, (u, v) -> Float.compare(dist(u), dist(v)));
        this.visited = new Boolean[size];
        this.prev = new Integer[size];
        this.dist = new Float[size];
        this.graph = graph;

        for (int i = 0; i < this.graph.size(); i++) {
            visited[i] = Boolean.FALSE;
            dist[i] = null;
            prev[i] = null;
        }
    }

    /* Returns the distance of the node from source */
    private Float dist(int node) {
        return this.dist[node];
    }

    public void shortedPathTree(int source) {
        this.dist[source] = 0f;
        this.q.add(source);

        while (!this.q.isEmpty()) {
            int current = this.q.remove();
            float cx = this.dist[current];

            if (DEBUG_FLAG) {
                System.out.println("current: " + current + "\t distance: " + cx);
            }

            if(this.visited[current]) {
                continue;
            } else {
                this.visited[current] = Boolean.TRUE;
            }

            for (Edge e : this.graph.getLinkedNodes(current)) {
                int next = e.getNode();
                float dx = cx + e.getDist();

                // update distance for this node if it is closer to current node
                if (this.dist[next] == null || dx < this.dist[next]) {
                    this.dist[next] = dx;
                    this.prev[next] = current;
                    this.q.add(next);
                }
            }
        }

        if (DEBUG_FLAG) {
            System.out.println("Input: source: " + source);
            results();
        }
    }

    public void results() {
        System.out.println("Output:");
        System.out.println("Node\t\tDistance from source");
        for (int i = 0; i < this.graph.size(); i++) {
            System.out.printf("%d \t\t %.1f \n", i, this.dist[i]);
        }
    }

    public List<Integer> getPath(int target) {
        List<Integer> resultSet = new LinkedList<>();
        if (this.graph.isValid(target)) {
            Integer u = target;
            while (u != null) {
                resultSet.add(0, u);
                u = prev[u];
            }
        }
        return resultSet;
    }
}
