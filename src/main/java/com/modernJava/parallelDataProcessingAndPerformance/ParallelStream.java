package com.modernJava.parallelDataProcessingAndPerformance;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {
        long sideEffectSum = sideEffectSum(10);
        System.out.println("sideEffectSum: " + sideEffectSum);

        long sideEffectParallelSum = sideEffectParallelSum(10_000_000);
        System.out.println("sideEffectParallelSum: " + sideEffectParallelSum);
    }

    static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i+1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i+1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    static public long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    static public long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    static public class Accumulator{
        public long total = 0;
        public void add(long value) {total += value;}
    }
}
