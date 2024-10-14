package com.modernJava.aSmallDSLForTheLatestJavaAPI.patternsAndTechniquesForCreatingDslInJava;

public class MixStockBuilder {
    private final MixTradeBuilder builder;
    private final Trade trade;
    private final Stock stock = new Stock();

    public MixStockBuilder(MixTradeBuilder builder, Trade trade, String symbol) {
        this.builder = builder;
        this.trade = trade;
        stock.setSymbol(symbol);
    }

    public MixTradeBuilder on(String market) {
        stock.setMarket(market);
        trade.setStock(stock);
        return builder;
    }
}
