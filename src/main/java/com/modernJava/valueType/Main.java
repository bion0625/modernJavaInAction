package com.modernJava.valueType;

public class Main {
    public static void main(String[] args) {
        double d1 = 3.14;
        double d2 = d1;
        Double o1 = d1;
        Double o2 = d2;
        Double ox = o1;
        System.out.println(d1 == d2 ? "yes" : "no");
        System.out.println(o1 == o2 ? "yes" : "no");
        System.out.println(o1 == ox ? "yes" : "no");
    }
}
