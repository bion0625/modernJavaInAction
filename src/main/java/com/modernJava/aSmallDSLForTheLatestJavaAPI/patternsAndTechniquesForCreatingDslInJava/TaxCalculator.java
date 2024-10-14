package com.modernJava.aSmallDSLForTheLatestJavaAPI.patternsAndTechniquesForCreatingDslInJava;

public class TaxCalculator {
    private boolean useRegional;
    private boolean useGeneral;
    private boolean useSurCharge;

    public TaxCalculator withTaxRegional() {
        useRegional = true;
        return this;
    }

    public TaxCalculator withTaxGeneral() {
        useGeneral = true;
        return this;
    }

    public TaxCalculator withTaxSurCharge() {
        useSurCharge = true;
        return this;
    }

    public double calculate(Order order) {
        return PatternsAndTechniquesForCreatingDslInJava.calculate(order, useRegional, useGeneral, useSurCharge);
    }
}
