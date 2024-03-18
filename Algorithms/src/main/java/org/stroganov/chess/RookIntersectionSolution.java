package org.stroganov.chess;

// Задача: На шахматной доске N*N стоят ладьи. Координаты каждой заданы двумя числами от 1 до N.
// Определить, сколько пар ладей бьют друг друга.
//Формула для вычисления количества пар ладей, бьющих друг друга:
//1. Перебираем все пары ладей
//2. Если координаты x или y совпадают, то увеличиваем счетчик на 1
//3. Возвращаем счетчик
//Пример:


public class RookIntersectionSolution {

public int rookIntersection(int chessDeskSize, int[][] rooksCoordinates) {
        int result = 0;
        //проверка на валидность входных данных
        if (chessDeskSize<=0 || rooksCoordinates==null || rooksCoordinates.length==0){
            throw new IllegalArgumentException("Invalid input data");
        }
        //решение задачи
        for (int i = 0; i < rooksCoordinates.length; i++) {
            for (int j = i + 1; j < rooksCoordinates.length; j++) {
                if (rooksCoordinates[i][0] == rooksCoordinates[j][0] || rooksCoordinates[i][1] == rooksCoordinates[j][1]) {
                    result++;
                }
            }
        }







        return result;
    }

}
