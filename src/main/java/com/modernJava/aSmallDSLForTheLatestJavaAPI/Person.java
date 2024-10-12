package com.modernJava.aSmallDSLForTheLatestJavaAPI;

public class Person {
    private String name;
    private int age;

    public String getName() {return this.name;}
    public int getAge() {return this.age;}
    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
