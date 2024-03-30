package org.stroganov.temperature_searching;

import java.util.Stack;

public class TemperatureStackSolution {

    public static int[] dailyTemperaturesCalculate(int[] temperatures) {
        int[] result = new int[temperatures.length]; //в массив мы добавляем разницу от индекса числа до индекса его следующего превышения по температуре
        Stack<TemperatureNode> temperatureNodeStack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!temperatureNodeStack.isEmpty() && temperatureNodeStack.peek().temperature < temperatures[i]) {
                temperatureNodeStack.pop();
            }
            if (temperatureNodeStack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = temperatureNodeStack.peek().indexofnexthotvalue - i;
                temperatureNodeStack.push(new TemperatureNode(temperatures[i], i));
            }
            temperatureNodeStack.push(new TemperatureNode(temperatures[i], i));
        }
        return result;
    }

    public static class TemperatureNode {
        int temperature;
        int indexofnexthotvalue;

        public TemperatureNode(int temperature, int indexOfNextHotValue) {
            this.temperature = temperature;
            this.indexofnexthotvalue = indexOfNextHotValue;
        }
    }

    //проход спереди
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}
