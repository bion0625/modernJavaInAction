package com.modernJava.optionalClassInsteadOfNull.mergeTwoOptionals;

import com.modernJava.optionalClassInsteadOfNull.introductionToOptionalClass.Car;
import com.modernJava.optionalClassInsteadOfNull.introductionToOptionalClass.Insurance;
import com.modernJava.optionalClassInsteadOfNull.introductionToOptionalClass.Person;

import java.util.Optional;

public class MergeTwoOptionals {
    public static void main(String args) {}

    public Insurance findCheapestInsurance(Person person, Car car) {
        return car.getInsurance().orElse(new Insurance());
    }

    public Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
//        if (person.isPresent() && car.isPresent()) {
//            return Optional.of(findCheapestInsurance(person.get(), car.get()));
//        } else return Optional.empty();
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }
}
