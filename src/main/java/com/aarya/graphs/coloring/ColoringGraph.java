/*
package com.aarya.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ColoringGraph<T> {
    List<Node<T>> nodes;

    public ColoringGraph(List<Node> arr) {
        nodes = new ArrayList<>(arr);
    }

    public List<Node<T>> getNodes() {
        return nodes;
    }

    public void add(Node node) {
        this.nodes.add(node);
    }

    public void addEdge(Node n1, Node n2) {
        int i1 = this.nodes.indexOf(n1);

        if (i1 < 0) { return; }

        this.nodes.get(i1).addEdge(n2);
    }

    public void print() {
        for (Node<T> n : this.nodes) {
            System.out.print(n + " --> ");
            for (Node<T> e : n.getEdges()) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    public int color() {
        if(getNodes().size() <= 1) {
            return getNodes().size();
        }

        HashMap<T, Boolean> visited = new HashMap<>();
        int maxColor = 1;

        // Greedy algorithm
        for (Node<T> node : getNodes()) {
            if (!visited.get(node.getValue())) {
                for (int i = 1; i <= maxColor + 1; i++) {
                    boolean flag = false;
                    for (Node<T> connection : node.getEdges()) {
                        if (connection.getColor() == i) {
                            flag = true;
                            break;
                        }
                    }

                    if (!flag) {
                        node.setColor(i);
                        break;
                    }
                }
                maxColor = Math.max(maxColor, node.getColor());
                visited.put(node.getValue(), Boolean.TRUE);
            }
        }

        System.out.println("Colors used: " + maxColor);

        return maxColor;
    }

}*/
