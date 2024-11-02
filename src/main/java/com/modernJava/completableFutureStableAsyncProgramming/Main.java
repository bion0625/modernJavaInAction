package com.modernJava.completableFutureStableAsyncProgramming;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Double> future = executor.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                return dosomelongcomputation();
            }
        });
        dosomethingelse();
        try {
            Double result = future.get(1, TimeUnit.SECONDS);
            //System.out.println("[3] rsult: " + result);
        } catch (ExecutionException ee) {
            //System.out.println("계산 중 예외 발생");
        } catch (InterruptedException ie) {
            //System.out.println("현재 스레드에서 대기 중 인터럽트 발생");
        } catch (TimeoutException te) {
            //System.out.println("Future가 완료되기 전에 타임아웃 발생");
        }

        executor.shutdown(); // 이거 왜 예제에 없지?
    }

    static Double dosomelongcomputation() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("[1] dosomelongcomputation");
        return 0.1;
    }

    static void dosomethingelse() {
        System.out.println("[2] dosomethingelse");
    }
}
