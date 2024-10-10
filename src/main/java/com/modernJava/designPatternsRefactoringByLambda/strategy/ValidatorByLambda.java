package com.modernJava.designPatternsRefactoringByLambda.strategy;

import java.util.function.Predicate;

public class ValidatorByLambda {
    private final Predicate<String> predicate;
    public ValidatorByLambda(Predicate<String> predicate) {
        this.predicate = predicate;
    }
    public boolean validate(String s) {
        return predicate.test(s);
    }
}
