package com.stroganow.graph;

import java.util.*;

/**
 * Consider an undirected graph where each edge weighs 6 units.
 * Each of the nodes is labeled consecutively from 1 to n.
 * <p>
 * You will be given a number of queries.
 * For each query, you will be given a list of edges describing an undirected graph.
 * After you create a representation of the graph, you must determine and report the shortest distance
 * to each of the other nodes from a given starting position using the breadth-first search algorithm  (BFS).
 * <p>
 * Return an array of distances from the start node in node number order.
 * If a node is unreachable, return  for that node.
 */

public class AllPathInGraphBSF {
    public static void main(String[] args) {
        /*1
        3 1
        2 3
        2*/
        // List<Integer> testCase = bfs(5, 3, List.of(List.of(1, 2), List.of(1, 3), List.of(3, 4)), 1);
        List<Integer> testCase2 = bfs(3, 1, List.of(List.of(2, 3)), 2);
        //testCase.forEach(System.out::println);
        testCase2.forEach(System.out::println);
    }

    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n - nodes
     *  2. INTEGER m - eges
     *  3. 2D_INTEGER_ARRAY edges from source to son;
     *  4. INTEGER s - start position;
     */
    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        int egePathValue = 6;
        Integer[] distance = new Integer[n + 1];
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, List<Integer>> graphMap = new HashMap<>();
        /// Rebuild graph as HashMap (undirected)
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            graphMap.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graphMap.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        graphMap.forEach((k, v) -> System.out.println(k + ":" + v));
        // add start to queue
        queue.add(s);
        distance[s] = 0;  // Start node distance is 0
        //graph iteration
        while (!queue.isEmpty()) {
            int parentNodeId = queue.poll();
            if (visited.contains(parentNodeId)) {
                continue;
            }
            visited.add(parentNodeId);
            List<Integer> neighborhoods = graphMap.getOrDefault(parentNodeId, Collections.emptyList());
            for (Integer nextNeighborhood : neighborhoods) {
                if (!visited.contains(nextNeighborhood)) {
                    queue.add(nextNeighborhood);
                    distance[nextNeighborhood] = distance[parentNodeId] + egePathValue;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < distance.length; i++) {
            if (i != s) {
                result.add(distance[i]);
            }
        }
        return result;
    }
}
