package com.modernJava.designPatternsRefactoringByLambda.strategy;

public class StrategyPattern {
    public static void main(String[] args) {
        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.validate("aaaa");
        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = lowerCaseValidator.validate("bbbb");
        System.out.println("b1: " + b1);
        System.out.println("b2: " + b2);

        ValidatorByLambda numericValidatorByLambda = new ValidatorByLambda(s -> s.matches("\\d+"));
        boolean b3 = numericValidatorByLambda.validate("aaaa");
        ValidatorByLambda lowerCaseValidatorByLambda = new ValidatorByLambda(s -> s.matches("[a-z]+"));
        boolean b4 = lowerCaseValidatorByLambda.validate("bbbb");
        System.out.println("b3: " + b3);
        System.out.println("b4: " + b4);
    }
}
