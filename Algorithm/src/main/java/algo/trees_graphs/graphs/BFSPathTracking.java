package algo.trees_graphs.graphs;

import java.util.*;

/**
 * This version of BFS finds the shortest path from s to e and returns the sequence of nodes in the path.
 */
public class BFSPathTracking {

    public static List<Integer> findShortestPath(int n, List<List<Integer>> edges, int s, int targetEnd) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // Build adjacency list
        for (List<Integer> edge : edges) {
            graph.computeIfAbsent(edge.get(0), k -> new ArrayList<>()).add(edge.get(1));
            graph.computeIfAbsent(edge.get(1), k -> new ArrayList<>()).add(edge.get(0)); // Undirected graph
        }
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> parentMap = new HashMap<>();  // To track the path
        Set<Integer> visited = new HashSet<>();

        queue.add(s);
        visited.add(s);
        parentMap.put(s, null);  // Root node has no parent
        // BFS loop
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            if (currentNode == targetEnd) {
                return constructPath(parentMap, targetEnd); // Reconstruct and return the path
            }
            for (int neighbor : graph.getOrDefault(currentNode, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    parentMap.put(neighbor, currentNode);  // Track where we came from step by step
                }
            }
        }
        return Collections.emptyList(); // No path found
    }

    // Helper function to reconstruct the path from parentMap
    private static List<Integer> constructPath(Map<Integer, Integer> parentMap, int end) {
        List<Integer> path = new ArrayList<>();
        for (Integer at = end; at != null; at = parentMap.get(at)) {
            path.add(at);
        }
        Collections.reverse(path); // Reverse to get the path from s -> e
        return path;
    }
}
