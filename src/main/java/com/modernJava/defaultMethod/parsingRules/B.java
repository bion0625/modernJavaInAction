package com.modernJava.defaultMethod.parsingRules;

public interface B extends A {
    default void hello() {
        System.out.println("Hello from B");
    }
}
