package com.dsalgo.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

class Graph {

    int noOfVertices;
    private ArrayList<ArrayList<Integer>> adjacencyMatrix;

    Graph(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adjacencyMatrix = new ArrayList<ArrayList<Integer>>(noOfVertices);
        for(int i =0; i< noOfVertices ;i++) {
            adjacencyMatrix.add(new ArrayList<Integer>());
        }
    }

    public void add(int vertex1, int vertex2) {
        adjacencyMatrix.get(vertex1).add(vertex2);
    }

    public void printAdjacencyMatrix() {
        for (int i=0; i < adjacencyMatrix.size(); i++) {
            System.out.print("\nVertex  " + i + ": ");
            for(int j= 0; j< adjacencyMatrix.get(i).size(); j++) {
                System.out.print("\t" + adjacencyMatrix.get(i).get(j));
            }
        }
    }

    public void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[noOfVertices];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }


        for (int i = 0; i < noOfVertices; i++) {
            if (visited[i] == false) {
                topologicalSortHelper(i, visited, stack);

            }
        }
        System.out.println("\n");
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + "\t");
        }
    }

    public void topologicalSortHelper(int vertex, boolean[] visited, Stack<Integer> stack) {

        visited[vertex] = true;

        Iterator<Integer> iterator = adjacencyMatrix.get(vertex).iterator();
        while (iterator.hasNext()) {
            int v = iterator.next();
            if (!visited[v]) {
                topologicalSortHelper(v, visited, stack);
            }
        }
        stack.push(vertex);
    }

}

class main {

    public static void main(String args[]) {
        Graph graph = new Graph(7);
        graph.add(5,2);
        graph.add(5,0);
        graph.add(4,0);
        graph.add(4,1);
        graph.add(2,3);
        graph.add(3,1);
        graph.add(7,5);
        graph.printAdjacencyMatrix();
        graph.topologicalSort();

    }
}