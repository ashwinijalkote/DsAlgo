package com.dsalgo.matrix;

import java.util.*;
import java.util.stream.Collectors;

public class DistanceFromOrigin {


    public boolean isEdgePresent(List<List<Integer>> area, int i, int j) {
        return area.get(i).get(j) == 0 ? false: true;
    }
    public static void constructGraph(List<List<Integer>> area) {
        Graph graph = new Graph(area.size());
        for (int i=0; i< area.size(); i++) {
            for(int j=0; j< area.get(i).size(); j++) {
                if (area.get(i).get(j) == 0) {
                    continue;
                }
                int [][] temp = {{i-1, j}, {i+1, j}, {i, j-1}, {i, j+1}};
                for (int k =0 ; k< temp.length; k++) {
                    int x= temp[k][0];
                    int y = temp[k][1];
                        try {
                            if (area.get(x).get(y) == 1) {
                                graph.addEdge(new Node(i, j), new Node(x, y));
                            }
                        } catch (IndexOutOfBoundsException e) {
                            continue;
                        }
                }

            }
        }
        graph.printGraph();
    }

    public static int minimumDistance(List<List<Integer>> area ) {
        constructGraph(area);
        return -1;
    }


    public  static void main(String args[]) {
        List<List<Integer>> area = new ArrayList<>();

            area.add(List.of(1,0,0));
            area.add(List.of(1,0,0));
            area.add(List.of(1,9,1));

        System.out.println(minimumDistance(area));


    }
}

class Graph {
    int numVertices;
    Set<Node> adjacencyMatrix;

    Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new HashSet<>();
    }

    public void addEdge(Node u, Node v) {
        System.out.println("before adding" + u.getNodes());
        u.addNode(v);
        System.out.println("after adding" + u.getNodes().size());
        adjacencyMatrix.add(u);
    }

    public void printGraph() {
        System.out.println(adjacencyMatrix.size());
            adjacencyMatrix.forEach(node -> {
                System.out.println("For node: " + node.getX() + " " + node.getY());
                System.out.println(node.getNodes().stream().collect(Collectors.toList()));
            });
    }
}

class Node {
    int y;
    int x;

    Set<Node> nodes;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void addNode(Node node) {
        if (nodes == null) {
            nodes = new HashSet<>();
        }
        nodes.add(node);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return y == node.y && x == node.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }

    @Override
    public String toString() {
        return "Node{" +
                "y=" + y +
                ", x=" + x +
                ", nodes=" + (nodes != null ? nodes.size() : 0) +
                '}';
    }
}
