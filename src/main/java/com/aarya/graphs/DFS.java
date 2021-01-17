package com.aarya.graphs;

public class DFS {
    public static void main(String args[]) {
        Graph g = new Graph(4);
        g.add(0, 1);
        g.add(0, 2);
        g.add(1, 2);
        g.add(2, 0);
        g.add(2, 3);
        g.add(3, 3);

        System.out.println("Graph");
        g.read();

        System.out.println("Starting depth first search from vertex 2");
        g.dfs(2);

        System.out.println("Starting breadth first search from vertex 2");
        g.bfs(2);
    }
}

