package com.modernJava.defaultMethod.diamondProblem;

public interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}
