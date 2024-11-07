package com.modernJava.arrays;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] evenNumbers = new int[10];
        Arrays.setAll(evenNumbers, i -> i * 2);
        System.out.println(Arrays.toString(evenNumbers));

        int[] ones = new int[10];
        Arrays.fill(ones, 1);
        Arrays.parallelPrefix(ones, (a, b) -> a + b);
        System.out.println(Arrays.toString(ones));
    }
}
