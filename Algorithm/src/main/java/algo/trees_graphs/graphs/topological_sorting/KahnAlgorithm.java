package algo.trees_graphs.graphs.topological_sorting;

import java.util.*;

/**
 * Топологическая сортировка
 * Считаем и сохраняем индекс связанности (указанности на них) каждой ноды с соседями т.е. если на (2) указывает три направленных ребра
 * индекс связанности - 3. Используем дополнительный массив куда заносим индексы
 * Создаем очередь куда изначально заносим ноды с индексом связнности на них - 0
 * Затем в цикле забираем ноду с 0 индексом из очереди, отнимаем у её соседей -1 т.е. уменьшаем их индекс связанности по этой ноде
 * проверяем если снова появились ноды с 0 связанностью заносим в очеред и повторяем цикл.
 */


public class KahnAlgorithm {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(3));
        graph.put(2, Arrays.asList(3));
        graph.put(3, Arrays.asList(4));
        graph.put(4, Arrays.asList());

        System.out.println(topologicalSort(5, graph)); // Output: [0, 1, 2, 3, 4] (or another valid order)
    }

    /*
    В мапе ключи - узлы, список исходящих направленных ребер в List
     */

    private static List<Integer> topologicalSort(int count, Map<Integer, List<Integer>> graph) {
        List<Integer> resultList = new ArrayList<>();
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>();
        int[] indeqree = new int[count];

        for (List<Integer> edgesList : graph.values()) {
            for (Integer nextNeighbor : edgesList) {
                indeqree[nextNeighbor]++;
            }
        }
        offerAllZerroIncomeNodes(integerPriorityQueue, indeqree);

        while (!integerPriorityQueue.isEmpty()) {
            int node = integerPriorityQueue.poll();
            resultList.add(node);
            List<Integer> neighbors = graph.get(node);
            for (Integer nextNeighbor : neighbors) {
                indeqree[nextNeighbor]--;
                if (indeqree[nextNeighbor] == 0) {
                    integerPriorityQueue.offer(nextNeighbor);
                }
            }
            //offerAllZerroIncomeNodes(integerPriorityQueue, indeqree);

        }

        if (resultList.size() != count) {
            throw new IllegalStateException("Graph contains a cycle! No topological order possible.");
        }
        return resultList;
    }

    private static void offerAllZerroIncomeNodes(PriorityQueue<Integer> integerPriorityQueue, int[] indeqree) {
        for (int i = 0; i < indeqree.length; i++) {
            if (indeqree[i] == 0) {
                integerPriorityQueue.offer(i);
                indeqree[i] = -1;
            }
        }
    }

}
