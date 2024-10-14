package com.modernJava.aSmallDSLForTheLatestJavaAPI.patternsAndTechniquesForCreatingDslInJava;

public class MixTradeBuilder {
    public Trade trade = new Trade();

    public MixTradeBuilder quantity(int quantity) {
        trade.setQuantity(quantity);
        return this;
    }

    public MixTradeBuilder at(double price) {
        trade.setPrice(price);
        return this;
    }

    public MixStockBuilder stock(String symbol) {
        return new MixStockBuilder(this, trade, symbol);
    }
}
