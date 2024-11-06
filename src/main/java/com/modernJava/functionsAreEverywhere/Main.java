package com.modernJava.functionsAreEverywhere;

import java.util.Arrays;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String, Integer> strToInt = Integer::parseInt;
        Arrays.stream("1231231231".split(""))
                .mapToInt(strToInt::apply)
                .forEach(System.out::println);
    }
}
