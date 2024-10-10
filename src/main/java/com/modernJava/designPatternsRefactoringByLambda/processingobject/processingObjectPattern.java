package com.modernJava.designPatternsRefactoringByLambda.processingobject;

import java.util.function.Function;

public class processingObjectPattern {
    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();
        p1.setSuccessor(p2);
        String result1 = p1.handle("Aren't labdas really sexy?!!");
        System.out.println("result1: " + result1);

        Function<String, String> headerTextProcessing = text -> "From Raoul, Mario and Alan: " + text;
        Function<String, String> spellCheckerProcessing = text -> text.replaceAll("labda", "lambda");
        Function<String, String> pipeline = headerTextProcessing.andThen(spellCheckerProcessing);
        String result2 = pipeline.apply("Aren't labdas really sexy?!!");
        System.out.println("result2: " + result2);
    }
}
