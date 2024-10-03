package com.modernJava.streamCollectingData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class CustomCollector {
    public Map<Boolean, List<Integer>> partitionPrimeWithCustomCollector1(int n) {
        return IntStream.range(2, n).boxed()
                .collect(new PrimeNumbersCollector());
    }

    public Map<Boolean, List<Integer>> partitionPrimeWithCustomCollector2(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(
                        () -> new HashMap<Boolean, List<Integer>>(){{
                            put(true, new ArrayList<Integer>());
                            put(false, new ArrayList<Integer>());
                        }},
                        (acc, candidate) -> {
                            acc.get(isPrime(acc.get(true), candidate))
                                    .add(candidate);
                            },
                        (map1, map2) -> {
                            map1.get(true).addAll(map2.get(true));
                            map1.get(false).addAll(map2.get(false));
                        });
    }

    public static boolean isPrime(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return primes.stream()
                .takeWhile(i -> i <= candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }
}
