package com.structures;

import com.structures.Edge;
import javafx.scene.Node;

import java.util.*;

public class PrimAlgorithm {
    private Map<Integer, Integer> indexes;
    private List<Edge>[] adjacencyList;

    public PrimAlgorithm(int vertices) {
        indexes = new HashMap<>();
        adjacencyList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public PrimAlgorithm(ArrayList<Node> nodes, ArrayList<Edge> edges) {
        indexes = new HashMap<>();
        adjacencyList = new ArrayList[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (Edge edge : edges) {
            addEdge(edge.getVertex1(), edge.getVertex2(), edge.getWeight());
        }
    }

    public void addEdge(int vertex1, int vertex2, int weight) {
        int index1 = getIndex(vertex1);
        int index2 = getIndex(vertex2);
        adjacencyList[index1].add(new Edge(vertex1, vertex2, weight));
        adjacencyList[index2].add(new Edge(vertex2, vertex1, weight));
    }

    public ArrayList<Edge> minimumSpanningTree() {
        ArrayList<Edge> result = new ArrayList<>();
        boolean[] visited = new boolean[indexes.size()];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.getWeight()));

        pq.add(new Edge(0, indexes.keySet().iterator().next(), 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int currentVertex = edge.getVertex2();

            if (visited[getIndex(currentVertex)]) continue;

            visited[getIndex(currentVertex)] = true;
            result.add(edge);

            for (Edge neighbor : adjacencyList[getIndex(currentVertex)]) {
                if (!visited[getIndex(neighbor.getVertex2())]) {
                    pq.add(neighbor);
                }
            }
        }

        return result;
    }

    private int getIndex(int vertex) {
        if (!indexes.containsKey(vertex)) {
            int index = indexes.size();
            indexes.put(vertex, index);
        }
        return indexes.get(vertex);
    }
}
