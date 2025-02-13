package algo.trees_graphs.graphs;

import java.util.*;

public class GraphNotOrientedTestData {
    public static void main(String[] args) {

    }
    private final Map<Integer, List<Integer>> graph = new HashMap<>();
    private final Map<Integer, Integer> memo = new HashMap<>(); // Запоминаем минимальный путь до узла

    public GraphNotOrientedTestData() {
        // Создаём граф в виде списка смежности
        // Добавляем рёбра (двусторонние связи для неориентированного графа)
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);
        addEdge(graph, 2, 5);
        addEdge(graph, 3, 6);
        addEdge(graph, 5, 7);
        addEdge(graph, 6, 8);
        addEdge(graph, 6, 9);
        // Вывод графа
        System.out.println("Граф (список смежности):");
        for (var entry : graph.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }

    // Метод для добавления ребра (двусторонняя связь)
    public void addEdge(Map<Integer, List<Integer>> graph, int u, int v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.putIfAbsent(v, new ArrayList<>());
        graph.get(u).add(v);
        graph.get(v).add(u);
        // improoved
        //  graph.merge(u, new ArrayList<>(List.of(v)), (oldList, newList) -> { oldList.add(v); return oldList; });
        //  graph.merge(v, new ArrayList<>(List.of(u)), (oldList, newList) -> { oldList.add(u); return oldList; });

    }

    // Обход в глубину (DFS) с рекурсией
    public void dfs(int node, Set<Integer> visited) {
        if (visited.contains(node)) return;
        System.out.print(node + " ");
        visited.add(node);
        for (int neighbor : graph.get(node)) {
            dfs(neighbor, visited);
        }
    }

    public int dfs(int node, int target, Set<Integer> visitedMemory) {
        if (node == target) return 0; // Базовый случай, Нашли цель, путь = 0 шагов
        if (memo.containsKey(node)) return memo.get(node); // Если уже вычисляли — сразу возвращаем
        visitedMemory.add(node);
        int minSteps = Integer.MAX_VALUE;
        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            if (!visitedMemory.contains(neighbor)) {
                int steps = dfs(neighbor, target, visitedMemory);
                if (steps != Integer.MAX_VALUE) { // Если нашли путь, обновляем minSteps
                    minSteps = Math.min(minSteps, steps + 1);
                }
            }
        }
        visitedMemory.remove(node); // Убираем из посещённых (чтобы не мешать другим путям)
        memo.put(node, minSteps); // Сохраняем результат в кэше
        return minSteps;
    }

    // Обход в ширину (BFS)
    public void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    public List<Integer> get(Integer node) {
        return graph.get(node);
    }
    public List<Integer> getOrDefault(int node, List<Integer> emptyList) {
        return graph.getOrDefault(node, emptyList);
    }
}
