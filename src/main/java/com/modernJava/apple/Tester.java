package com.modernJava.apple;

import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(AppleColor.GREEN, 155));
        inventory.add(new Apple(AppleColor.RED, 80));

        prettyPrintApple(inventory, new AppleFancyFormatter());
        prettyPrintApple(inventory, new AppleSimpleFormatter());

        prettyPrintApple(inventory, a -> a.getWeight() > 150 ? a.getWeight() + " is heavy" : a.getWeight() + " is light");
    }
    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter appleFormatter) {
        for (Apple apple : inventory) {
            String output = appleFormatter.accept(apple);
            System.out.println(output);
        }
    }
}
