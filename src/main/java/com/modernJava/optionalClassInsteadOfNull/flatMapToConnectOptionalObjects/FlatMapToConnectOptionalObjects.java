package com.modernJava.optionalClassInsteadOfNull.flatMapToConnectOptionalObjects;

import com.modernJava.optionalClassInsteadOfNull.introductionToOptionalClass.Car;
import com.modernJava.optionalClassInsteadOfNull.introductionToOptionalClass.Insurance;
import com.modernJava.optionalClassInsteadOfNull.introductionToOptionalClass.Person;

import java.util.Optional;

public class FlatMapToConnectOptionalObjects {
    public static void main(String[] args) {
        FlatMapToConnectOptionalObjects connect = new FlatMapToConnectOptionalObjects();
        String name = connect.getCarInsuranceName(Optional.empty());
        System.out.println("name: " + name);
    }

    public String getCarInsuranceName(Optional<Person> person) {
        return person
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
}
