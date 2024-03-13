package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    private Map<Character, Set<Character>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public boolean addVertex(Character vertex) {
        if (adjList.containsKey(vertex)) return false;

        adjList.put(vertex, new HashSet<>());
        return true;
    }

    public boolean addEdge(Character vertex1, Character vertex2) {
        if (!adjList.containsKey(vertex1) || !adjList.containsKey(vertex2)) {
            return false;
        }

        Set<Character> v1 = adjList.get(vertex1);
        Set<Character> v2 = adjList.get(vertex2);

        if (v1.contains(vertex2)) return false;
        if (v2.contains(vertex1)) return false;

        v1.add(vertex2);
        v2.add(vertex1);

        return true;
    }

    public boolean removeEdge(Character vertex1, Character vertex2) {
        if (!adjList.containsKey(vertex1) || !adjList.containsKey(vertex2)) {
            return false;
        }

        Set<Character> v1 = adjList.get(vertex1);
        Set<Character> v2 = adjList.get(vertex2);

        v1.remove(vertex2);
        v2.remove(vertex1);

        return true;
    }

    public boolean removeVertex(Character vertex) {
        if (!adjList.containsKey(vertex)) {
            return false;
        }

        Set<Character> edges = adjList.get(vertex);
        
        for (Character edge : edges) {
            adjList.get(edge).remove(vertex);
        }

        adjList.remove(vertex);

        return true;
    }

    public void printGraph() {
        System.out.println(adjList);
    }
}
