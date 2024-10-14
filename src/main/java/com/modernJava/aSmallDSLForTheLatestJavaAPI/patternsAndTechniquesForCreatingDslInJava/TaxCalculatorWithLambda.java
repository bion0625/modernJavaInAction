package com.modernJava.aSmallDSLForTheLatestJavaAPI.patternsAndTechniquesForCreatingDslInJava;

import java.util.function.DoubleUnaryOperator;

public class TaxCalculatorWithLambda {
    public DoubleUnaryOperator taxFunction = d -> d;

    public TaxCalculatorWithLambda with(DoubleUnaryOperator f) {
        taxFunction = taxFunction.andThen(f);
        return this;
    }

    public double calculate(Order order) {
        return taxFunction.applyAsDouble(order.getValue());
    }
}
