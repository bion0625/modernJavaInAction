package com.modernJava.aSmallDSLForTheLatestJavaAPI.patternsAndTechniquesForCreatingDslInJava;

import java.util.function.Consumer;

public class LambdaOrderBuilder {
    private Order order = new Order();

    public static Order order(Consumer<LambdaOrderBuilder> consumer) {
        LambdaOrderBuilder builder = new LambdaOrderBuilder();
        consumer.accept(builder);
        return builder.order;
    }
    public void forCustomer(String customer) {
        order.setCustomer(customer);
    }
    public void buy(Consumer<TradeBuilderByLambda> consumer) {
        trade(consumer, Trade.Type.BUY);
    }
    public void sell(Consumer<TradeBuilderByLambda> consumer) {
        trade(consumer, Trade.Type.SELL);
    }
    private void trade(Consumer<TradeBuilderByLambda> consumer, Trade.Type type) {
        TradeBuilderByLambda builder = new TradeBuilderByLambda();
        builder.trade.setType(type);
        consumer.accept(builder);
        order.addTrade(builder.trade);
    }
}
