package com.modernJava.parallelDataProcessingAndPerformance;

import com.modernJava.forkJoinFramework.ForkJoinSumCalculator;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G"})
public class ParallelStreamBenchmark {
    private static final long N = 10_000_000L;

//    @Benchmark
//    public long sequentialSum() {
//        return Stream.iterate(1L, i -> i+1).limit(N)
//                .reduce(0L, Long::sum);
//    } // modernJava.ParallelStreamBenchmark.sequentialSum  avgt   40  130638.153 ± 18203.346  us/op

//    @Benchmark
//    public long iterativeSum() {
//        long result = 0L;
//        for (long i = 1L; i <= N; i++) {
//            result += i;
//        }
//        return result;
//    } // modernJava.ParallelStreamBenchmark.iterativeSum  avgt   40  3511.583 ± 163.495  us/op

//    @Benchmark
//    public long parallelSum() {
//        return Stream.iterate(1L, i -> i+1).limit(N)
//                .parallel()
//                .reduce(0L, Long::sum);
//    } // modernJava.ParallelStreamBenchmark.parallelSum  avgt   40  205447.905 ± 4269.058  us/op

//    @Benchmark
//    public long rangedSum() {
//        return LongStream.rangeClosed(1, N)
//                .reduce(0L, Long::sum);
//    } // modernJava.ParallelStreamBenchmark.rangedSum  avgt   40  3401.706 ± 96.401  us/op

//    @Benchmark
//    public long parallelRangedSum() {
//        return LongStream.rangeClosed(1, N)
//                .parallel()
//                .reduce(0L, Long::sum);
//    } // modernJava.ParallelStreamBenchmark.parallelRangedSum  avgt   40  646.279 ± 27.541  us/op

//    @Benchmark
//    public long sideEffectParallelSum() {
//        return ParallelStream.sideEffectParallelSum(N);
//    } // modernJava.parallelDataProcessingAndPerformance.ParallelStreamBenchmark.sideEffectParallelSum  avgt   40  1825.640 ± 69.649  us/op

    @Benchmark
    public long forkJoinSumCalculator() {
        return forkJoinSum(N);
    } // modernJava.parallelDataProcessingAndPerformance.ParallelStreamBenchmark.forkJoinSumCalculator  avgt   40  36988.672 ± 3583.553  us/op

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }

    @TearDown(Level.Invocation)
    public void tearDown() {
        System.gc();
    }
}