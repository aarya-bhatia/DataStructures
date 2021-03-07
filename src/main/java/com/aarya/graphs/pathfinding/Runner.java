package com.aarya.graphs.pathfinding;

public class Runner {

    public static void main(String[] args) {
        Graph graph = new Graph(9);

        graph.addEdge(0,1,4);
        graph.addEdge(0,7,8);

        graph.addEdge(1,2,8);
        graph.addEdge(1,7,11);

        graph.addEdge(2,3,7);
        graph.addEdge(2,8,2);
        graph.addEdge(2,5,4);

        graph.addEdge(3,4,9);

        graph.addEdge(5,6,2);
        graph.addEdge(5,3,14);
        graph.addEdge(5,4,10);

        graph.addEdge(6, 8, 6);

        graph.addEdge(7,8,7);
        graph.addEdge(7, 6,1);

        graph.show();

        System.out.println("RUNNING SHORTEST PATH TREE ALGORITHM...");
        ShortestPath spf = new ShortestPath(graph, true);
        spf.shortedPathTree(0);
        System.out.println("Here is the shortest path from 0 to 8");
        System.out.println(spf.getPath(8));
    }
}
