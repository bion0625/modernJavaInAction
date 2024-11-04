package com.modernJava.completableFutureStableAsyncProgramming.handleCompletableFutureCompletion;

import java.util.Random;

public class Discount {
    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    private static final Random random = new Random();

    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is " +
                Discount.apply(quote.getPrice(),
                        quote.getDiscountCode());
    }

    public static double apply(double price, Code code) {
        delay();
        return format(price * (100 - code.percentage) / 100);
    }

    public static void delay() {
        int delay = 500 + random.nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static double format(double price) {
        return (double) Math.round(price * 100) / 100;
    }
}
