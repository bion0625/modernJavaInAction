package com.modernJava.streamAndLazyEvaluation;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
//        IntStream numbers = numbers();
//        primes(numbers).forEach(System.out::println);

        MyLinkedList<Integer> l =
                new MyLinkedList<>(5, new MyLinkedList<>(10, new Empty<>()));
        System.out.println(l);

//        LazyList<Integer> numbers = from(2);
//        int two = numbers.head();
//        int three = numbers.tail().head();
//        int four = numbers.tail().tail().head();
//        System.out.println(two + " " + three + " " + four);

        LazyList<Integer> numbers = from(2);
        Integer two = primes(numbers).head();
        Integer three = primes(numbers).tail().head();
        Integer five = primes(numbers).tail().tail().head();
        System.out.println(two + " " + three + " " + five);

        printAll(primes(from(2)));
    }

    static IntStream numbers() {
        return IntStream.iterate(2, n -> n+1);
    }

    static int head(IntStream numbers) {
        return numbers.findFirst().getAsInt();
    }

    static IntStream tail(IntStream numbers) {
        return numbers.skip(1);
    }

    static IntStream primes(IntStream numbers) {
        int head = head(numbers);
        return IntStream.concat(
                IntStream.of(head),
                primes(tail(numbers).filter(n -> n % head != 0)));
    }

    public static LazyList<Integer> from(int n) {
        return new LazyList<>(n, () -> from(n+1));
    }

    public static MyList<Integer> primes(MyList<Integer> numbers) {
        return new LazyList<>(
                numbers.head(),
                () -> primes(
                        numbers.tail().filter(n -> n % numbers.head() != 0)
                )
        );
    }

    static <T> void printAll(MyList<T> list) {
//        while (!list.isEmpty()) {
//            System.out.println(list.head());
//            list = list.tail();
//        }
        if (list.isEmpty()) return;
        System.out.println(list.head());
        printAll(list.tail());
    }
}
