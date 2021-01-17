package com.aarya.graphs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

    /* Maps each vertex to an integer representing
     * the index of the adjacency list for that vertex
     */
    HashMap<String, Integer> map;

    /* Adjacency List  */
    LinkedList<Integer> adj[];

    /* Number of vertices */
    int V;

    @SuppressWarnings("unchecked")
    public Graph(int V) {
        this.V = V;
        this.adj = new LinkedList[V];
        for(int i = 0; i < V; i++) {
            this.adj[i] = new LinkedList<Integer>();
        }
        this.map = new HashMap<String, Integer>();
    }

    /* Calls previous constructor to initialize members
     * Then, invokes the create method to construct the graph
     */
    public Graph(int _V, String[] vertices, String[][] edges) {
        this(_V);
        this.create(vertices, edges);
    }

    /**
     * Constructs a graph with given vertices and edges
     *
     * @param vertices
     * @param edges
     */
    public void create(String[] vertices, String[][] edges) {
        for(int i = 0; i < V; i++) {
            map.put(vertices[i], i);
        }

        for(int i = 0; i < edges.length; i++) {
            int u = map.get(edges[i][0]);
            int v = map.get(edges[i][1]);
            add(u, v);
        }
    }

    /**
     * Add an edge from vertex u to v
     *
     * @param u
     * @param v
     */
    public void add(int u, int v) {
        adj[u].add(v);
    }

    public void read() {
        for(int i = 0; i < V; i++) {
            for(Integer v: adj[i]) {
                System.out.printf("%d -> %d \n", i, v);
            }
        }
    }

    /**
     * Performs a depth first search on the graph instance
     * starting from specified vertex.
     * Time Complexity: O(V + E)
     * where V is the number of vertices
     * and E is the number of edges
     * in the graph.
     *
     * @param start
     */
    public void dfs(int start) {
        boolean[] visited = new boolean[V];
        dfs(visited, -1, start);
    }

    /**
     * Helper method to recursively perform DFS from current vertex
     * Previous vertex is passed to print the exact path to output
     * Visited array helps avoid duplicate passes in the method
     *
     * @param visited
     * @param previous
     * @param current
     */
    private void dfs(boolean[] visited, int previous, int current) {
        visited[current] = true;
        if(previous != -1) {
            System.out.printf("%d -> %d \n", previous, current);
        } else {
            System.out.println("At " + current);
        }

        Iterator<Integer> it = adj[current].listIterator();

        while(it.hasNext()) {
            int next = it.next();
            if(!visited[next]) {
                dfs(visited, current, next);
            }
        }
    }

    public void bfs(int start) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[start] = true;
        queue.add(start);

        int previous = -1;

        while(queue.size()>0) {
            int current = queue.poll();
            if(previous != -1) {
                System.out.println(previous + " -> " + current);
            }
            else {
                System.out.println(current);
            }
            previous = current;

            Iterator<Integer> iterator = adj[current].listIterator();

            while(iterator.hasNext()) {
                int next = iterator.next();
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }

        }

    }
}

