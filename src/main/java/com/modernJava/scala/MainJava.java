package com.modernJava.scala;

import java.util.function.Function;
import java.util.stream.Stream;

public class MainJava {
    public static void main(String[] args) {
//        int count = 0;
//        Runnable inc = () -> count+=1;
//        inc.run();
//        System.out.println(count);
//        inc.run();

        int r = multiply(2, 10);
        System.out.println("r: " + r);

        Stream.of(1, 3, 5, 7)
                .map(multiplyCurry(2))
                .forEach(System.out::println);
    }

    static int multiply(int x, int y) {
        return x * y;
    }

    static Function<Integer, Integer> multiplyCurry(int x) {
        return (Integer y) -> x * y;
    }
}
