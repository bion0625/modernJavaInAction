package com.modernJava.defaultMethod.multipleInheritanceOfBehavior;

public class MultipleInheritanceOfBehavior {
    public static void main(String[] args) {
        Monster m = new Monster();
        m.rotateBy(180);
        m.moveVertically(10);
        System.out.println(m);
    }
}
