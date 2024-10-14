package com.modernJava.aSmallDSLForTheLatestJavaAPI.patternsAndTechniquesForCreatingDslInJava;

import static com.modernJava.aSmallDSLForTheLatestJavaAPI.patternsAndTechniquesForCreatingDslInJava.NestedFunctionOrderBuilder.*;

public class PatternsAndTechniquesForCreatingDslInJava {
    public static void main(String[] args) {
        Order order1 = new Order();
        order1.setCustomer("BigBank");

        Trade trade1 = new Trade();
        trade1.setType(Trade.Type.BUY);

        Stock stock1 = new Stock();
        stock1.setSymbol("IBM");
        stock1.setMarket("NYSE");

        trade1.setStock(stock1);
        trade1.setPrice(125.00);
        trade1.setQuantity(80);
        order1.addTrade(trade1);

        Trade trade2 = new Trade();
        trade2.setType(Trade.Type.SELL);

        Stock stock2 = new Stock();
        stock2.setSymbol("GOOGLE");
        stock2.setMarket("NASDAQ");

        trade2.setStock(stock2);
        trade2.setPrice(375.00);
        trade2.setQuantity(50);
        order1.addTrade(trade2);

        System.out.println("order1: " + order1);

        Order order2 = MethodChainingOrderBuilder.forCustomer("BigBank")
                .buy(80)
                .stock("IBM")
                .on("NYSE")
                .at(125.00)
                .sell(50)
                .stock("GOOGLE")
                .on("NSADAQ")
                .at(375.00)
                .end();
        System.out.println("order2: " + order2);


        Order order3 = order("BigBank",
                            buy(80,
                                stock("IBM", on("NYSE")), at(125.00)),
                            sell(50,
                                stock("GOOGLE", on("NASDAQ")), at(375.00))
                            );
        System.out.println("order3: " + order3);

        Order order4 = LambdaOrderBuilder.order(o -> {
            o.forCustomer("BigBank");
            o.buy(t -> {
                t.quantity(80);
                t.price(125.00);
                t.stock(s -> {
                    s.symbol("IBM");
                    s.market("NYSE");
                });
            });
            o.sell(t -> {
                t.quantity(50);
                t.price(375.00);
                t.stock(s -> {
                    s.symbol("GOOGLE");
                    s.market("NASDAQ");
                });
            });
        });
        System.out.println("order4: " + order4);

        Order order5 = MixBuilder.forCustomer("BigBank",
                MixBuilder.buy(t -> t.quantity(80)
                        .stock("IBM")
                        .on("NYSE")
                        .at(125.00)),
                MixBuilder.sell(t -> t.quantity(50)
                        .stock("GOOGLE")
                        .on("NASDAQ")
                        .at(125.00)));
        System.out.println("order5: " + order5);

        double value1 = new TaxCalculator().withTaxRegional()
                                        .withTaxSurCharge()
                                        .calculate(order5);
        System.out.println("value1: " + value1);

        double value2 = new TaxCalculatorWithLambda().with(Tax::regional)
                                                    .with(Tax::surcharge)
                                                    .calculate(order5);
        System.out.println("value2: " + value2);
    }

    public static double calculate(Order order, boolean useRegional, boolean useGeneral, boolean useSurCharge) {
        double value = order.getValue();
        if (useRegional) value = Tax.regional(value);
        if (useGeneral) value = Tax.general(value);
        if (useSurCharge) value = Tax.surcharge(value);
        return value;
    }
}
