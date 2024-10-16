package com.modernJava.optionalClassInsteadOfNull.optionalStreamManipulation;

import com.modernJava.optionalClassInsteadOfNull.introductionToOptionalClass.Car;
import com.modernJava.optionalClassInsteadOfNull.introductionToOptionalClass.Insurance;
import com.modernJava.optionalClassInsteadOfNull.introductionToOptionalClass.Person;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OptionalStreamManipulation {
    public static void main(String[] args) {

        Function<String, Person> getPerson = name -> {
            Insurance insurance = new Insurance();
            insurance.setName(name);

            Car car = new Car();
            car.setInsurance(insurance);

            Person person = new Person();
            person.setCar(car);

            return person;
        };

        List<Person> persons = List.of(
                new Person(),
                getPerson.apply("nameA"),
                getPerson.apply("nameB"),
                getPerson.apply("nameC"),
                getPerson.apply("nameD")
        );
        OptionalStreamManipulation app = new OptionalStreamManipulation();
        Set<String> names = app.getCarInsuranceNames(persons);
        System.out.println("names: " + names);
    }
    public Set<String> getCarInsuranceNames(List<Person> persons) {
        return persons.stream()
                .map(Person::getCar)
                .map(optCar -> optCar.flatMap(Car::getInsurance))
                .map(optIns -> optIns.map(Insurance::getName))
                .flatMap(Optional::stream)
//                .map(optStr -> optStr.orElse("Unknown"))
                .collect(Collectors.toSet());
    }
}
