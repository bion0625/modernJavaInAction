package com.modernJava.designPatternsRefactoringByLambda.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class FeedByLambda {
    private final List<Consumer<String>> consumers = new ArrayList<>();
    public void registerObserver(Consumer<String> o) {
        this.consumers.add(o);
    }

    public void notifyObserver(String tweet) {
        consumers.forEach(o -> o.accept(tweet));
    }
}
