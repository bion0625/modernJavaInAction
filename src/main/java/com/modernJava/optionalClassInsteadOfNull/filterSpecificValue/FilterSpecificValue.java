package com.modernJava.optionalClassInsteadOfNull.filterSpecificValue;

import com.modernJava.optionalClassInsteadOfNull.introductionToOptionalClass.Car;
import com.modernJava.optionalClassInsteadOfNull.introductionToOptionalClass.Insurance;
import com.modernJava.optionalClassInsteadOfNull.introductionToOptionalClass.Person;

import java.util.Optional;

public class FilterSpecificValue {
    public static void main(String[] args) {

        Insurance insurance = new Insurance();
        insurance.setName("personA");

        Car car = new Car();
        car.setInsurance(insurance);

        Person person = new Person();
        person.setCar(car);
        person.setAge(30);

        FilterSpecificValue app = new FilterSpecificValue();
        String name1 = app.getCarInsuranceName(Optional.of(person), 30);
        String name2 = app.getCarInsuranceName(Optional.of(person), 31);

        System.out.println("name1: " + name1);
        System.out.println("name2: " + name2);
    }

    public String getCarInsuranceName(Optional<Person> person, int minAge) {
        return person
                .filter(p -> p.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
}
