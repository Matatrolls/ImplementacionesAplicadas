package com.structures;

import java.util.*;

public class KruskalAlgorithm<T> {
    private Map<Integer, Integer> indexes;
    private ArrayList<Edge> edges;
    private int[] parent;

    public KruskalAlgorithm(ArrayList<Edge> edges) {
        this.edges = edges;
        this.indexes = new HashMap<>();
    }

    public ArrayList<Edge> minimumSpanningTree() {
        ArrayList<Edge> result = new ArrayList<>();
        
        Collections.sort(edges);
        parent = new int[indexes.size()];
        for (int i = 0; i < indexes.size(); i++) {
            parent[i] = i;
        }

        for (Edge edge : edges) {
            int index1 = getIndex(edge.getVertex1());
            int index2 = getIndex(edge.getVertex2());

            if (find(index1) != find(index2)) {
                result.add(edge);
                union(index1, index2);
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

    private int find(int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        parent[rootX] = rootY;
    }


}
