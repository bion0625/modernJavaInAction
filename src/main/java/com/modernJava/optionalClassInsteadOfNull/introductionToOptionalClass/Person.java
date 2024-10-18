package com.modernJava.optionalClassInsteadOfNull.introductionToOptionalClass;

import java.util.Optional;

public class Person {
    private Optional<Car> car = Optional.empty();
    private int age;

    public Optional<Car> getCar() {
        return this.car;
    }
    public void setCar(Car car) {
        this.car = Optional.ofNullable(car);
    }

    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
