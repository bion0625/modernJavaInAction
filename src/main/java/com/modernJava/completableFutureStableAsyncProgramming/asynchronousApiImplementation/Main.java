package com.modernJava.completableFutureStableAsyncProgramming.asynchronousApiImplementation;

import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop("Best shop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPricesAsync("my favorite product");
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        dosomethingElse();

        try {
            Double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        long retrievalTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    public static void dosomethingElse() {
        System.out.println("dosomethingElse");
    }
}
