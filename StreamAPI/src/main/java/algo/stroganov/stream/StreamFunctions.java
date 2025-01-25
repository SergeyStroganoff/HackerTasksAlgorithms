package algo.stroganov.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFunctions {


    public static void main(String[] args) {
        StreamFunctions streamFunctions = new StreamFunctions();


        // map function - преобразование элементов потока в другие элементы потока
        streamFunctions.generateIntegerStream().map(n -> n * 2).forEach(System.out::println);

        streamFunctions.generateStringStream()
                .mapToInt(String::length)
                .forEach(System.out::println);

        Stream.of("3", "4", "5")
                .map(Integer::parseInt)
                .map(x -> x + 10)
                .forEach(System.out::println);


        /*
        flatMap(Function<T, Stream<R>> mapper)
flatMap function - преобразование элементов потока в другие элементы потока
Один из самых интересных операторов. Работает как map, но с одним отличием
— можно преобразовать один элемент в ноль, один или множество других.

Для того, чтобы один элемент преобразовать в ноль элементов, нужно вернуть null, либо пустой
стрим. Чтобы преобразовать в один элемент, нужно вернуть стрим из одного элемента, например,
через Stream.of(x). Для возвращения нескольких элементов, можно любыми способами создать
стрим с этими элементами.
         */

        Stream.of("3", "4", "5")
                .flatMap(x -> Stream.of(Integer.parseInt(x)))
                .forEach(System.out::println);

        Stream.of(2, 3, 0, 1, 3)
                .flatMapToInt(x -> IntStream.range(0, x))
                .forEach(System.out::println);


        Stream.of(1, 2, 3, 4, 5, 6)
                .flatMap(x -> switch (x % 2) {
                    case 0 -> Stream.of(x, x * x, x * x * x);
                    case 1 -> Stream.of(x);
                    default -> Stream.empty();
                })
                .forEach(System.out::println);

        Stream.of(1, 2, 3, 4, 5, 6)
                .flatMap(x -> {
                    if (x % 2 == 0) {
                        return Stream.of(-x, x);
                    }
                    return Stream.empty();
                })
                .forEach(System.out::println);

//        -2, 2, -4, 4, -6, 6


/*
        mapMulti(BiConsumer < T, Consumer < R >> mapper)
        Появился в Java 16. Этот оператор похож на flatMap, но использует императивный подход при работе.
        Теперь вместе с элементом стрима приходит ещё и Consumer, в который можно передать одно или несколько
        значений, либо не передавать вовсе.
*/

        Stream.of(1, 2, 3, 4, 5, 6)
                .mapMulti((x, consumer) -> {
                    if (x % 2 == 0) {
                        consumer.accept(-x);
                        consumer.accept(x);
                    }
                })
                .forEach(System.out::println);
// -2, 2, -4, 4, -6, 6


        /*
        Function Limit
         */

        Stream.of(120, 410, 85, 32, 314, 12)
                .limit(4)
                .forEach(System.out::println);


/*      Skip(long n)
        Пропускает n элементов стрима.*/

        Stream.of(5, 10)
                .skip(40)
                .forEach(System.out::println);


/*        sorted()
        sorted(Comparator comparator)
        Сортирует элементы стрима. Причём работает этот оператор очень хитро:
        если стрим уже помечен как отсортированный, то сортировка проводиться не будет,
        иначе соберёт все элементы, отсортирует их и вернёт новый стрим, помеченный как отсортированный.*/

        Stream.of(120, 410, 85, 32, 314, 12)
                .sorted()
                .forEach(System.out::println);
        // 12, 32, 85, 120, 314, 410

        Stream.of(120, 410, 85, 32, 314, 12)  //сортировка в процессе убывания
                .sorted((x, y) -> y - x)
                .forEach(System.out::print);

/*        distinct()
        Убирает дубликаты из стрима.
 */

        Stream.of(2, 1, 8, 1, 3, 2)
                .distinct()
                .forEach(System.out::println);


        /*
        peek(Consumer action)
Выполняет действие над каждым элементом стрима и при этом возвращает стрим с элементами исходного стрима.
 Служит для того, чтобы передать элемент куда-нибудь, не разрывая при этом цепочку операторов
  (вы же помните, что forEach — терминальный оператор и после него стрим завершается?), либо для отладки.
         */
        Stream.of(0, 3, 0, 0, 5)
                .peek(x -> System.out.format("before distinct: %d%n", x))
                .distinct()
                .peek(x -> System.out.format("after distinct: %d%n", x))
                .map(x -> x * x)
                .forEach(x -> System.out.format("after map: %d%n", x));


    /*
    takeWhile(Predicate predicate)
Появился в Java 9. Возвращает элементы до тех пор, пока они удовлетворяют условию,
 то есть функция-предикат возвращает true.
 Это как limit, только не с числом, а с условием.
     */

        Stream.of(1, 2, 3, 4, 5, 6)
                .takeWhile(x -> x < 4)
                .forEach(System.out::println);



        /*
        dropWhile(Predicate predicate)

Появился в Java 9. Пропускает элементы до тех пор, пока они удовлетворяют условию,
 затем возвращает оставшуюся часть стрима. Если предикат вернул для первого элемента false,
  то ни единого элемента не будет пропущено.
 Оператор подобен skip, только работает по условию.
         */

        Stream.of(1, 2, 3, 4, 5, 6)
                .dropWhile(x -> x < 4)
                .forEach(System.out::println);

        /*
        boxed()
Преобразует примитивный стрим в объектный.
         */
        IntStream.of(1, 2, 3, 4, 5, 6)
                .boxed()//преобразование в объектный стрим
                .forEach(System.out::println);


    }


    private Stream<Integer> generateIntegerStream() {
        return Stream.of(1, 2, 3, 4, 5);
    }

    private Stream<String> generateStringStream() {
        return Stream.of("apple", "banana", "cherry", "date");
    }
}
