package com.modernJava.aSmallDSLForTheLatestJavaAPI.patternsAndTechniquesForCreatingDslInJava;

public class StockBuilderByLambda {
    public Stock stock = new Stock();
    public void symbol(String symbol) {
        stock.setSymbol(symbol);
    }
    public void market(String market) {
        stock.setMarket(market);
    }
}
