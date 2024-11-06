package com.modernJava.recursionAndIteration;

import com.modernJava.apple.Apple;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.LongStream;

import static com.modernJava.apple.AppleColor.GREEN;
import static com.modernJava.apple.AppleColor.RED;

public class Main {
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple(GREEN, 80),
                new Apple(GREEN, 155),
                new Apple(RED, 120));

        Iterator<Apple> it = apples.iterator();
        while (it.hasNext()) {
            Apple apple = it.next();
            System.out.println(apple);
        }

        System.out.println("factorialIterative(10): " + factorialIterative(10));
        System.out.println("factorialRecursive(10): " + factorialRecursive(10));
        System.out.println("factorialStreams(10): " + factorialStreams(10));
        System.out.println("factorialTailRecursive(10): " + factorialTailRecursive(10));
    }

    static int factorialIterative(int n) {
        int r = 1;
        for (int i = 1; i <= n; i++) {
            r *= i;
        }
        return r;
    }

    static int factorialRecursive(int n) {
        return n == 1 ? 1 : n * factorialRecursive(n-1);
    }

    static long factorialStreams(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (long a, long b) -> a * b);
    }

    static long factorialTailRecursive(long n) {
        return factorialHelper(1, n);
    }

    static long factorialHelper(long acc, long n) {
        return n == 1 ? acc : factorialHelper(acc * n, n-1);
    }
}
