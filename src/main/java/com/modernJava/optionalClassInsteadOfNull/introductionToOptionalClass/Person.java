package com.modernJava.optionalClassInsteadOfNull.introductionToOptionalClass;

import java.util.Optional;

public class Person {
    private Optional<Car> car = Optional.empty();
    public Optional<Car> getCar() {
        return this.car;
    }
    public void setCar(Car car) {
        this.car = Optional.ofNullable(car);
    }
}
