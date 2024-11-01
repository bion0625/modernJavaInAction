package com.modernJava.publishSubscribeAndReactiveProgramming.exampleOfCombiningTwoFlows;

public interface Subscriber<T> {
    void onNext(T t);
}
