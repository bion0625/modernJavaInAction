package com.modernJava.publishSubscribeAndReactiveProgramming.exampleOfCombiningTwoFlows;

public interface Publisher<T> {
    void subscribe(Subscriber<? super T> subscriber);
}
