package com.modernJava.aSmallDSLForTheLatestJavaAPI.collectorsAsDslForCollectingData;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorsAsDslForCollectingData {
    public static void main(String[] args) {
        List<Car> cars = List.of(new Car("A", "GREEN"),
                new Car("B", "YELLOW"),
                new Car("C", "GREEN"),
                new Car("C", "GRAY"),
                new Car("W", "GREEN"),
                new Car("A", "GREEN"));
        Map<String, Map<String, List<Car>>> carsByBrandAndColor =
                cars.stream().collect(Collectors.groupingBy(Car::getBrand,
                        Collectors.groupingBy(Car::getColor)));
        System.out.println(carsByBrandAndColor);

        Collector<? super Car, ?, Map<String, Map<String, List<Car>>>>
                carGroupingCollector =
                GroupingBuilder.groupOn(Car::getColor).after(Car::getBrand).get();
        System.out.println(carGroupingCollector);
    }
}
