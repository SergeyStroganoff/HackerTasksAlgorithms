package org.stroganov.bagpack;


// Реализация задачи о рюкзаке с помощью динамического программирования

import java.util.ArrayList;

public class BagPackDP {

    public int bagPackDP(int maxWeight, int[] weightOfItems, int[] valOfItems, int n, boolean isLogActive) throws InterruptedException {
        //MaxWeight - вместимость рюкзака
        //weightOfItems - массив весов предметов
        //valOfItems - массив ценностей предметов
        //n - количество предметов
        int itemNumber;
        int currentWeight;
        // Создание таблицы для хранения результатов
        // K[i][w] хранит максимальную ценность для i предметов и вместимости рюкзака w
        int matrix[][] = new int[n + 1][maxWeight + 1];

        // Построение таблицы K[][] в bottom up manner
        for (itemNumber = 0; itemNumber <= n; itemNumber++) { //перебираем все предметы
            for (currentWeight = 0; currentWeight <= maxWeight; currentWeight++) { //перебираем все веса
                if (itemNumber == 0 || currentWeight == 0)
                    matrix[itemNumber][currentWeight] = 0;
                else if (weightOfItems[itemNumber - 1] <= currentWeight) //если вес предмета меньше или равен текущему весу т.е. если мы не превысели текущий расчитывваемый вес прибавив этот прдмет
                    // записываем в ячейку для даного предмета лучьшую стоимость, которую получаем либо не взяв этот предмет либо взяв его и прибавив стоимость с предыдущим предметом
                    matrix[itemNumber][currentWeight] = Math.max(valOfItems[itemNumber - 1] + matrix[itemNumber - 1][currentWeight - weightOfItems[itemNumber - 1]], matrix[itemNumber - 1][currentWeight]);
                    //выбираем максимальное значение из двух вариантов: берем предмет или нет (в зависимости от того, что больше) и записываем в таблицу результат для текущего веса и предмета (или без него) и для предыдущего предмета
                else
                    matrix[itemNumber][currentWeight] = matrix[itemNumber - 1][currentWeight]; //если вес предмета больше текущего веса, то записываем в таблицу результат для текущего веса и предыдущего предмета т.е. точно не берем предмет
                print(matrix[itemNumber][currentWeight] + " ", isLogActive);
            }
            print("\n", isLogActive);
        }
        getItemsNumbers(matrix, weightOfItems, valOfItems, n, maxWeight);
        return matrix[n][maxWeight];
    }

    private void getItemsNumbers(int[][] matrix, int[] weightOfItems, int[] valOfItems, int n, int maxWeight) {
        int currentValue = matrix[n][maxWeight];
        ArrayList<Integer> itemsNumbers = new ArrayList<>();
        int i = 0;
        while (i < n) {
            if (matrix[n-i][maxWeight] != currentValue) {
                itemsNumbers.add(weightOfItems[n - i]);
                currentValue -= valOfItems[n - i];
            }
            i++;
        }
        itemsNumbers.forEach(x-> System.out.println("weight: " + x));
    }

    public void print(Object s, boolean isActive) throws InterruptedException {
        if (isActive) {
            System.out.print(s);
            Thread.sleep(1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BagPackDP bagPackDP = new BagPackDP();
        int[] weights = {2, 3, 4, 5};
        int[] values = {2, 4, 5, 7};
        int maxValueOfBagPack = bagPackDP.bagPackDP(7, weights, values, 4, true);
        System.out.println(maxValueOfBagPack);
    }
}
