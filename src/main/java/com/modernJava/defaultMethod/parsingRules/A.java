package com.modernJava.defaultMethod.parsingRules;

public interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}
