package algo.trees_graphs.graphs;

import java.util.*;

public class TestApp {
    public static void main(String... args) {
        GraphNotOrientedTestData graphNotOrientedTestData = new GraphNotOrientedTestData();

        graphNotOrientedTestData.bfs(1);

        System.out.println("Колличество минимальных шагов до ноды 5: " + graphNotOrientedTestData.dfs(1, 5, new HashSet<>()));

        dfsFindAllPaths(graphNotOrientedTestData, 1, 5)
                .forEach((k, v) -> System.out.printf("Путь длинна: %s ноды: %s ", k, v));
    }

    //todo
    public static Map<Integer, List<List<Integer>>> dfsFindAllPaths(GraphNotOrientedTestData graph, int start, int target) {
        Map<Integer, List<List<Integer>>> pathMap = new HashMap<>();
        Stack<List<Integer>> stack = new Stack<>();
        stack.push(List.of(start));

        while (!stack.isEmpty()) {
            List<Integer> pathVisited = stack.pop(); // снимаем со стека список нод и берем последнюю
            int node = pathVisited.get(pathVisited.size() - 1); //сохраняем ноду

            if (node == target) { // если нашли таргет
                pathMap.computeIfAbsent(pathVisited.size(), k -> new ArrayList<>()).add(new ArrayList<>(pathVisited));
                continue;
            }

            for (int nextNode : graph.getOrDefault(node, Collections.emptyList())) {
                if (!pathVisited.contains(nextNode)) {
                    List<Integer> newPath = new ArrayList<>(pathVisited);
                    newPath.add(nextNode);
                    stack.push(newPath);
                }
            }
        }
        return pathMap;
    }
}
