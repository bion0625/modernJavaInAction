package com.modernJava.designPatternsRefactoringByLambda.processingobject;

public class HeaderTextProcessing extends ProcessingObject<String>{
    @Override
    protected String handleWork(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }
}
