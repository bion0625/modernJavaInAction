package com.modernJava.streamCollectingData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectorHarness {
    public static void main(String[] args) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            partitionPrimes(1_000_000);// Fastest execution done in 1022298600 msecs
//            partitionPrimeWithCustomCollector1(1_000_000);// Fastest execution done in 318996300 msecs
//            partitionPrimeWithCustomCollector2(1_000_000);// Fastest execution done in 578542200 msecs
            long duration = System.nanoTime() - start;
            if (duration < fastest) fastest = duration;
        }
        System.out.println(
                "Fastest execution done in " + fastest + " msecs");
    }

    static Map<Boolean, List<Integer>> partitionPrimes (int n) {
        return IntStream.range(2, n).boxed()
                .collect(Collectors.partitioningBy(candidate -> isPrime1(candidate)));
    }

    static public boolean isPrime1(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.range(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    static public Map<Boolean, List<Integer>> partitionPrimeWithCustomCollector1(int n) {
        return IntStream.range(2, n).boxed()
                .collect(new PrimeNumbersCollector());
    }

    static public Map<Boolean, List<Integer>> partitionPrimeWithCustomCollector2(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(
                        () -> new HashMap<Boolean, List<Integer>>(){{
                            put(true, new ArrayList<Integer>());
                            put(false, new ArrayList<Integer>());
                        }},
                        (acc, candidate) -> {
                            acc.get(isPrime2(acc.get(true), candidate))
                                    .add(candidate);
                        },
                        (map1, map2) -> {
                            map1.get(true).addAll(map2.get(true));
                            map1.get(false).addAll(map2.get(false));
                        });
    }

    public static boolean isPrime2(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return primes.stream()
                .takeWhile(i -> i <= candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }
}
