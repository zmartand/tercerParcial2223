package org.example;

import java.util.*;

public class Graph<V> {
    // Lista de adyacencia.
    private Map<V, Set<V>> adjacencyList = new HashMap<>();

    public boolean addVertex(V v) {
        if (!adjacencyList.containsKey(v)) {
            adjacencyList.put(v, new HashSet<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(V v1, V v2) {
        addVertex(v1);
        addVertex(v2);
        return adjacencyList.get(v1).add(v2);
    }

    public Set<V> obtainAdjacents(V v) throws Exception {
        if (!adjacencyList.containsKey(v)) {
            throw new Exception("El vértice no está en el grafo.");
        }
        return adjacencyList.get(v);
    }

    public boolean containsVertex(V v) {
        return adjacencyList.containsKey(v);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (V v : adjacencyList.keySet()) {
            sb.append(v.toString()).append(": ");
            for (V adjacent : adjacencyList.get(v)) {
                sb.append(adjacent.toString()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<V> onePath(V v1, V v2) {
        Map<V, V> trace = new HashMap<>();
        Stack<V> openSet = new Stack<>();
        openSet.push(v1);
        trace.put(v1, null); // El vértice de inicio no tiene padre.
        boolean found = false;

        while (!openSet.isEmpty() && !found) {
            V current = openSet.pop();

            if (current.equals(v2)) {
                found = true;
            } else {
                for (V neighbor : adjacencyList.get(current)) {
                    if (!trace.containsKey(neighbor)) {
                        openSet.push(neighbor);
                        trace.put(neighbor, current);
                    }
                }
            }
        }

        if (found) {
            List<V> path = new ArrayList<>();
            V current = v2;
            while (current != null) {
                path.add(0, current);
                current = trace.get(current);
            }
            return path;
        } else {
            return null;
        }
    }
}
