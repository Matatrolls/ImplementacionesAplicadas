package com.structures;

import java.util.Arrays;

public class FloydWarshallAlgorithm {
    private int[][] dist;
    private int[][] next;
    private int numVertices;
    private static final int INF = 999999; // Valor infinito para representar la ausencia de conexión

    public FloydWarshallAlgorithm(int numVertices) {
        this.numVertices = numVertices;
        dist = new int[numVertices][numVertices];
        next = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            Arrays.fill(dist[i], INF);
            Arrays.fill(next[i], -1);
        }
    }


    public void addEdge(int vertex1, int vertex2, int weight) {
        dist[vertex1][vertex2] = weight;
        next[vertex1][vertex2] = vertex2;
    }


    public void floydWarshall() {
        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k]; // Actualizar el siguiente nodo intermedio
                    }
                }
            }
        }
    }

    // Método para obtener el camino más corto entre dos vértices
    public String getShortestPath(int start, int end) {
        floydWarshall();
        if (dist[start][end] == INF) {
            return "No hay camino entre los niveles " + (start+1) + " y " + (end+1);
        }

        StringBuilder path = new StringBuilder();
        path.append("El camino más corto entre los niveles ").append((start+1)).append(" y ").append((end+1)).append(" es:\n ").append(" -> "+(start+1)+"\n");

        while (start != end) {
            start = next[start][end];
            path.append(" -> ").append((start+1)+"\n");
        }

        return path.toString();
    }
}