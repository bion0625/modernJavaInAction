package com.modernJava.aSmallDSLForTheLatestJavaAPI.patternsAndTechniquesForCreatingDslInJava;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class MixBuilder {
    public static Order forCustomer(String customer, MixTradeBuilder... builders) {
        Order order = new Order();
        order.setCustomer(customer);
        Stream.of(builders).forEach(b -> order.addTrade(b.trade));
        return order;
    }

    public static MixTradeBuilder buy(Consumer<MixTradeBuilder> consumer) {
        return buildTrade(consumer, Trade.Type.BUY);
    }

    public static MixTradeBuilder sell(Consumer<MixTradeBuilder> consumer) {
        return buildTrade(consumer, Trade.Type.SELL);
    }

    private static MixTradeBuilder buildTrade(Consumer<MixTradeBuilder> consumer, Trade.Type buy) {
        MixTradeBuilder builder = new MixTradeBuilder();
        builder.trade.setType(buy);
        consumer.accept(builder);
        return builder;
    }
}
