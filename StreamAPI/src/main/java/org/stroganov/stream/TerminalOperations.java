package org.stroganov.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalOperations {

    public static void main(String[] args) {

        Stream.of(120, 410, 85, 32, 314, 12)
                .forEach(x -> System.out.format("%s, ", x));

        /*
        long count()
Возвращает количество элементов стрима.
         */

        int distinctNumber = (int) Stream.of(120, 410, 85, 32, 314, 12, 12, 410, 10, 12)
                .distinct()
                .count();
        System.out.println();

        long count = IntStream.range(0, 10)
                .flatMap(x -> IntStream.range(0, x))
                .count();
        System.out.println(count);


        /*
        R collect(Collector collector)
Один из самых мощных операторов Stream API.
 С его помощью можно собрать все элементы в список, множество или другую коллекцию,
 сгруппировать элементы по какому-нибудь критерию, объединить всё в строку и т.д..
 В классе java.util.stream.Collectors очень много методов на все случаи жизни,
 мы рассмотрим их позже. При желании можно написать свой коллектор, реализовав интерфейс Collector.
         */

        String s = Stream.of(1, 2, 3)
                .map(String::valueOf)
                .collect(Collectors.joining("-", "<", ">"));

        System.out.printf("Result: %s%n", s);


        List<Integer> list = Stream.of(1, 2, 3)
                .collect(Collectors.toList());
// list: [1, 2, 3]


        /*
        R collect(Supplier supplier, BiConsumer accumulator, BiConsumer combiner)

То же, что и collect(collector), только параметры разбиты для удобства.
Если нужно быстро сделать какую-то операцию, нет нужды реализовывать интерфейс Collector,
достаточно передать три лямбда-выражения:
  - supplier должен поставлять новые объекты (контейнеры), например new ArrayList(),
  - accumulator добавляет элемент в контейнер,
  -combiner необходим для параллельных стримов и объединяет части стрима воедино.
         */

        List<String> list2 = Stream.of("a", "b", "c", "d")
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);


        /*
        List<T> toList()

Наконец-то добавлен в Java 16. Возвращает список, подобно collect(Collectors.toList()).
 Отличие в том, что теперь возвращаемый список гарантированно нельзя будет модифицировать.
  Любое добавление или удаление элементов в полученный список будет сопровождаться исключением
   UnsupportedOperationException.
         */

        List<String> elements = Stream.of("a", "b", "c", "d")
                .map(String::toUpperCase)
                .toList();


        /*
        T reduce(T identity, BinaryOperator accumulator)

U reduce(U identity, BiFunction accumulator, BinaryOperator combiner)
Ещё один полезный оператор. Позволяет преобразовать все элементы стрима в один объект. Например, посчитать сумму всех элементов, либо найти минимальный элемент.
Сперва берётся объект identity и первый элемент стрима, применяется функция accumulator и identity становится её результатом. Затем всё продолжается для остальных элементов.
         */

        int sum = Stream.of(1, 2, 3, 4, 5)
                .reduce(10, (acc, x) -> acc + x);


        //Optional Reduce
        //Если стрим пустой, то вернётся Optional.empty().
        //Если стрим содержит один элемент, то вернётся Optional этого элемента.
        Optional<Integer> summ = Stream.of(1, 2, 3, 4, 5)
                .reduce((acc, x) -> acc + x);
        System.out.println(summ.get());
// 15

        // Min and Max
        int min = Stream.of(20, 11, 45, 78, 13)
                .min(Integer::compare).get();
        System.out.println(min);
// min: 11

        int max = Stream.of(20, 11, 45, 78, 13)
                .max(Integer::compare).get();
        System.out.println(max);


    /*     FindFirst
         findFirst() возвращает первый элемент стрима в виде Optional.
         Если стрим пустой, то вернётся Optional.empty().
         Если стрим не пустой, то вернётся Optional с первым элементом.*/

        Optional<Integer> first = Stream.of(1, 2, 3, 4, 5)
                .findFirst();
        System.out.println(first.get());

        /*FindAny
        findAny() возвращает любой элемент стрима в виде Optional.
         */

        Optional<Integer> any = Stream.of(1, 2, 3, 4, 5)
                .findAny();

        /*
        boolean allMatch(Predicate predicate)
Возвращает true, если все элементы стрима удовлетворяют условию predicate.
 Если встречается какой-либо элемент, для которого результат вызова функции-предиката будет false,
  то оператор перестаёт просматривать элементы и возвращает false.
         */

        boolean allMatch = Stream.of(2, 4, 6, 8, 10)
                .allMatch(x -> x % 2 == 0);
        System.out.println(allMatch);

        /*
        boolean anyMatch(Predicate predicate)
Возвращает true, если хотя бы один элемент стрима удовлетворяет условию predicate.
         */
        boolean anyMatch = Stream.of(2, 4, 6, 8, 10)
                .anyMatch(x -> x % 2 != 0);
        System.out.println(anyMatch);

        /*
        boolean noneMatch(Predicate predicate)
Возвращает true, если ни один элемент стрима не удовлетворяет условию predicate.
         */

        boolean noneMatch = Stream.of(2, 4, 6, 8, 10)
                .noneMatch(x -> x % 2 != 0);

        System.out.println(noneMatch);

        /*
        OptionalDouble average()
Только для примитивных стримов. Возвращает среднее арифметическое всех элементов. Либо Optional.empty, если стрим пуст.
         */
        OptionalDouble average = IntStream.of(2, 4, 6, 8, 10)
                .average();
        System.out.println(average.getAsDouble());

        /*
        sum()
Возвращает сумму элементов примитивного стрима.
 Для IntStream результат будет типа int, для LongStream — long, для DoubleStream — double.
         */

        int sum1 = IntStream.of(2, 4, 6, 8, 10)
                .sum();
        System.out.println(sum1);

        /*
       toArray()
         */
        Object[] objects = Stream.of(1, 2, 3, 4, 5)
                .toArray();
        //toList
        List<Integer> list1 = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toList());

        List<Integer> list3 = Stream.of(1, 2, 3, 4, 5).toList();
        //toSet
        Set<Integer> set = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toSet());


        /*
        toMap(Function keyMapper, Function valueMapper)
        Собирает элементы в Map. Каждый элемент преобразовывается в ключ и в значение, основываясь на результате функций keyMapper и valueMapper соответственно. Если нужно вернуть тот же элемент, что и пришел, то можно передать Function.identity()
*/

        Map<Integer, Integer> map1 = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toMap(
                        Function.identity(),
                        Function.identity()
                ));

        Map<Integer, Integer> map2 = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toMap(
                        k -> k, // key the same
                        v -> v + 10 // value= key + 10
                ));


        /*
        toMap(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction)
        Собирает элементы в Map. Каждый элемент преобразовывается в ключ и в значение, основываясь на результате функций keyMapper и valueMapper соответственно. Если ключи совпадают,
         то вызывается mergeFunction и возвращается результат.
         */

        Map<Integer, Integer> map3 = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toMap(
                        k -> k, // key the same
                        v -> v + 10, // value= key + 10
                        (v1, v2) -> v1 + v2 // merge function sum
                ));


        /*
        minBy(Comparator comparator)
maxBy(Comparator comparator)
Поиск минимального/максимального элемента, основываясь на заданном компараторе.
         */

        Optional<Integer> min1 = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.minBy(Integer::compare));


    }
}
