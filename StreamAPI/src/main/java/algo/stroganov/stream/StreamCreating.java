package algo.stroganov.stream;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamCreating {

    /**
     * Stream API
     * Stream API - это новый инструмент в Java 8, который позволяет нам работать с коллекциями объектов.
     * Stream API предоставляет нам возможность писать более чистый и понятный код.
     * Stream API предоставляет нам возможность использовать функциональное программирование в Java.
     * Stream API не изменяет исходную коллекцию, а возвращает новую коллекцию с результатом.
     * Stream API не хранит результат в памяти, а обрабатывает данные по мере поступления.
     * Stream API позволяет нам использовать лямбда-выражения для обработки данных.
     * Stream API позволяет нам использовать встроенные функциональные интерфейсы.
     * Stream API позволяет нам использовать методы высшего порядка.
     * Stream API позволяет нам использовать функции высшего порядка.
     *
     * @param args
     */

    public static void main(String[] args) {

        // Empty stream
        Stream.empty().forEach(System.out::println);

        // Stream of values
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).forEach(System.out::println);

        // Stream of array
        Stream.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}).forEach(System.out::println);

        //Стрим из массива:
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Stream.of(array).forEach(System.out::println);
        Arrays.stream(array).forEach(System.out::println); // the  same but излишнее создание стрима


        //- IntStream для int
        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).forEach(System.out::println);
        //- LongStream для long
        LongStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).forEach(System.out::println);
        //- DoubleStream для double
        DoubleStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).forEach(System.out::println);

        // Stream of range - не включая последний элемент
        IntStream.range(1, 10).forEach(System.out::println);

        // Stream of rangeClosed - включая последний элемент
        IntStream.rangeClosed(1, 10).forEach(System.out::println);

        // Stream of iterate
        Stream.iterate(1, i -> i + 1).limit(10).forEach(System.out::println);

        // Stream of generate
        Stream.generate(() -> 1).limit(10).forEach(System.out::println);

        // Stream of concat
        Stream.concat(Stream.of(1, 2, 3), Stream.of(4, 5, 6)).forEach(System.out::println);

        // Stream of builder
        Stream.builder().add(1).add(2).add(3).build().forEach(System.out::println);

        // Stream of empty
        Stream.empty().forEach(System.out::println);

        // Stream of nullable - не создает стрим, если передан null - используется для избежания NullPointerException
        Stream.ofNullable(null).forEach(System.out::println);

        // Stream of nullable - создает стрим, если передан null
        Stream.ofNullable(1).forEach(System.out::println);


    }


}
