package com.specflare.algohut.bulk;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

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
    class BlogPost {
        String title;
        String author;
        BlogPostType type;
        int likes;
    }

    enum BlogPostType {
        NEWS,
        REVIEW,
        GUIDE
    }

    class Tuple {
        BlogPostType type;
        String author;
    }

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

        // streams from maps
        Map<String, Integer> someMap = new HashMap<>();
        Set<Map.Entry<String, Integer>> entries = someMap.entrySet();
        Set<String> keySet = someMap.keySet();
        Collection<Integer> values = someMap.values();

        Map<String, String> books = new HashMap<>();
        books.put("978-0201633610", "Design patterns : elements of reusable object-oriented software");
        books.put("978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");
        books.put("978-0134685991", "Effective Java");

        Optional<String> optionalIsbn = books.entrySet().stream()
                .filter(e -> "Effective Java".equals(e.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();
        // optionalIsbn.get() is "978-0134685991"

//        List<BlogPost> posts = Arrays.asList( ... );
//        Map<BlogPostType, List<BlogPost>> postsPerType = posts.stream().collect(groupingBy(BlogPost::getType));
//
//        Map<Pair<BlogPostType, String>, List<BlogPost>> postsPerTypeAndAuthor = posts.stream()
//                .collect(groupingBy(post -> new ImmutablePair<>(post.getType(), post.getAuthor())));
    }
}
