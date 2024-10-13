package com.modernJava.aSmallDSLForTheLatestJavaAPI.patternsAndTechniquesForCreatingDslInJava;

import java.util.function.Consumer;

public class TradeBuilderByLambda {
    public Trade trade = new Trade();
    public void quantity(int quantity) {
        trade.setQuantity(quantity);
    }
    public void price(double price) {
        trade.setPrice(price);
    }
    public void stock(Consumer<StockBuilderByLambda> consumer) {
        StockBuilderByLambda builder = new StockBuilderByLambda();
        consumer.accept(builder);
        trade.setStock(builder.stock);
    }
}
