package algo.trees_graphs.graphs;

import java.util.*;

/**
 * Как работает алгоритм Дейкстры:
 * Алгоритм начинает с исходной вершины, устанавливая её кратчайшее расстояние равным 0, а расстояния до остальных вершин — бесконечными.
 * Используется приоритетная очередь (мин-куча), которая всегда извлекает вершину с минимальным расстоянием.
 * Для каждой соседней вершины алгоритм проверяет, можно ли улучшить расстояние до неё, пройдя через текущую вершину.
 * Если да, обновляется расстояние, и эта вершина добавляется в очередь для дальнейшей обработки.
 * Процесс повторяется, пока все вершины не будут обработаны.
 * <p>
 * Если задача стоит только найти толко растояник до конкретной ноды, то как только находим то выходим сразу из цикла
 * break;
 */

public class DijkstraAlgo {
    public static Map<Integer, Integer> dijkstra(Map<Integer, List<int[]>> graph, int start) {
        Map<Integer, Integer> distMap = new HashMap<>();
        // минимум очередь с приоритетом - компаратор по второму элементу массива (массив точка вес пути к ней)
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        // Инициализируем расстояния - заносим в мапу все ноды и расстояния до них бесконечные изначально
        for (int node : graph.keySet()) {
            distMap.put(node, Integer.MAX_VALUE);
        }
        distMap.put(start, 0);  // переназначаем стартовой ноде растояние до нее 0
        priorityQueue.add(new int[]{start, 0}); // добавляем первый найденную дистанцию в очередь - 0

        while (!priorityQueue.isEmpty()) { // поиск в ширину пока очередь не пуста
            int[] current = priorityQueue.poll(); // вытягиваем из очереди самую ближнюю ноду в виде [нода, растояние]
            int node = current[0];
            int currDist = current[1];

            //ищем в мапе ноду и если есть у нее растояние то сравнивваем
            // если расстояние в мапе короче - оптимальнее текущего, то выходим из цикла
            if (currDist > distMap.get(node)) {
                continue;
            } // Уже найден лучший путь

            /**
             * в цикле перебираем всех родственников берем у них номер ноды и растояние до неё
             * вычисляем дистанцию до ноды путем прибавления растояние текущей ноды + растояние до родственника
             * проверяем в мапе расстояний - если полученное растоянее меньше уже имеющего (оптимальнее) то
             * кладем в мапу расстояний и выбираем такую ноду как дальнейший путь для этого добавляем в приоритетную очередь
             * идем в начало цикла
             * в конце возвращаем мапу расстояний
             */
            for (int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {

                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDist = distMap.get(node) + weight;

                if (newDist < distMap.get(nextNode)) {
                    distMap.put(nextNode, newDist);
                    priorityQueue.add(new int[]{nextNode, newDist});
                }
            }
        }
        return distMap;
    }

    public static void main(String[] args) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        graph.put(0, List.of(new int[]{1, 4}, new int[]{2, 1}));
        graph.put(1, List.of(new int[]{3, 6}));
        graph.put(2, List.of(new int[]{3, 2}));
        graph.put(3, new ArrayList<>());

        System.out.println(dijkstra(graph, 0)); // {0=0, 1=4, 2=1, 3=3}
    }


}
