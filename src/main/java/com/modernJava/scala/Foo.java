package com.modernJava.scala;

import java.util.*;
import java.util.stream.IntStream;

public class Foo {
    public static void main(String[] args) {
        IntStream.rangeClosed(2, 6)
                .forEach(n -> System.out.println("Hello " + n + " bottles of beer"));

//        Map<String, Integer> authorsToAge = new HashMap<>();
//        authorsToAge.put("Raoul",23);
//        authorsToAge.put("Mario",40);
//        authorsToAge.put("Alan",53);
        Map<String, Integer> authorsToAge
                = Map.ofEntries(
                        Map.entry("Raoul", 23),
                        Map.entry("Mario", 40),
                        Map.entry("Alan", 53));
        System.out.println(authorsToAge);

        Set<Integer> numbers = new HashSet<>();
        Set<Integer> newNumbers = Collections.unmodifiableSet(numbers);
        System.out.println(numbers);
        System.out.println(newNumbers);

        Pair<String, String> raoul = new Pair<>("Raoul", "+ 44 007007007");
        Pair<String, String> alan = new Pair<>("Alan", "+ 44 003133700");
        System.out.println(raoul);
        System.out.println(alan);
    }
}
