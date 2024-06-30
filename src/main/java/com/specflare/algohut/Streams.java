package com.specflare.algohut;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * functional interfaces:
 *  - Consumer<T>: void accept(T t);
 *  - Predicate<T>: boolean test(T t);
 *  - Function<T, R>: R apply(T t);
 *  - Supplier<T>: T get();
 *  How the functional interfaces are used with streams:
 *      - void forEach(Consumer<? super T> action);
 *      - Stream<T> filter(Predicate<? super T> predicate);
 *      - <R> Stream<R> map(Function<? super T, ? extends R> mapper);
 *      - <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner);
 */

public class Streams {
    public static void main(String[] args) {
        List<Integer> result = Stream.of("Ana are mere", "Otopeni Bucuresti Paris")
                    .flatMap(s -> Stream.of(s.split(" ")))
                    .map(String::length)
                    .collect(Collectors.toList());
        System.out.println(result);

        System.out.println("--");
        Stream.of(new Integer[] {1,2,3,4,5,6}).forEach(System.out::println);

        System.out.println("--");
        Integer[] intArr = List.of(new Integer[] {1,2,3,4,5,6})
                .parallelStream()
                // .forEach(System.out::println);
                .toArray(Integer[]::new);

        System.out.println("--");
        Random rand = new Random();
        // the random function is called only 10 times.
        Stream.generate(() -> rand.nextInt(100))
                .parallel()
                .limit(10) // limit is required here with the generate () function.
                .forEach(System.out::println);
    }
}
