package com.modernJava.aSmallDSLForTheLatestJavaAPI;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ASmallDSLForTheLatestJavaAPI {
    public static void main(String[] args) {
        List<Person> persons1 = Arrays.asList(
                new Person("minsu", 30),
                new Person("chulsu", 31),
                new Person("huyngsu", 29));
        Collections.sort(persons1, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getAge() - p2.getAge();
            }
        });
        System.out.println("persons1: " + persons1);

        List<Person> people = Arrays.asList(
                new Person("minsu", 30),
                new Person("chulsu", 31),
                new Person("huyngsu", 29));
        Collections.sort(people, (p1, p2) -> p1.getAge() - p2.getAge());
        System.out.println("people: " + people);

        List<Person> persons2 = Arrays.asList(
                new Person("minsu", 30),
                new Person("chulsu", 31),
                new Person("huyngsu", 29));
        Collections.sort(persons2, Comparator.comparing(p -> p.getAge()));
        System.out.println("persons2: " + persons2);

        List<Person> persons3 = Arrays.asList(
                new Person("minsu", 30),
                new Person("minsu", 31),
                new Person("minsu", 29),
                new Person("chulsu", 30),
                new Person("huyngsu", 30));
        Collections.sort(persons3, Comparator.comparing(Person::getAge));
        System.out.println("persons3: " + persons3);
        Collections.sort(persons3, Comparator.comparing(Person::getAge).reversed());
        System.out.println("persons3: " + persons3);
        Collections.sort(persons3, Comparator.comparing(Person::getAge).thenComparing(Person::getName));
        System.out.println("persons3: " + persons3);

        List<Person> persons4 = Arrays.asList(
                new Person("minsu", 30),
                new Person("minsu", 31),
                new Person("minsu", 29),
                new Person("chulsu", 30),
                new Person("huyngsu", 30));
        persons4.sort(Comparator.comparing(Person::getAge).thenComparing(Person::getName));
        System.out.println("persons4: " + persons4);
    }
}
