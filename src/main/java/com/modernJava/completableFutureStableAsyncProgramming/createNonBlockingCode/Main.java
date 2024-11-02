package com.modernJava.completableFutureStableAsyncProgramming.createNonBlockingCode;

import com.modernJava.completableFutureStableAsyncProgramming.asynchronousApiImplementation.Shop;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

public class Main {

    static private List<Shop> shops;
    public static void main(String[] args) {
        shops = Arrays.asList(new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll"));

        long start = System.nanoTime();
        System.out.println(findPrices("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }

    static public List<String> findPrices(String product) {
//        return shops.parallelStream()
//        return shops.stream()
//                .map(shop -> String.format("%s price is %.2f",
//                        shop.getName(), shop.getPrice(product)))
//                .collect(Collectors.toList());

        ExecutorService executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            }
        });

        List<CompletableFuture<String>> pricesFuture = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> String.format("%s price is %.2f",
//                                shop.getName(), shop.getPrice(product))))
                                shop.getName(), shop.getPrice(product)), executor))
                .collect(Collectors.toList());

        return pricesFuture.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
}
