package com.modernJava.executeMultipleOperationsInParallelOnStream;

import com.modernJava.streamUsing.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Dish> menu = new ArrayList<>(List.of(
                new Dish("prawns", false, 3203, Dish.Type.FISH),
                new Dish("salmon", false, 300, Dish.Type.FISH),
                new Dish("french", false, 140, Dish.Type.OTHER),
                new Dish("fries", false, 561, Dish.Type.OTHER),
                new Dish("rice", false, 70, Dish.Type.OTHER),
                new Dish("season", false, 42, Dish.Type.OTHER),
                new Dish("fruit", true, 1000, Dish.Type.OTHER),
                new Dish("pizza", false, 1000, Dish.Type.OTHER),
                new Dish("pork", false, 1000, Dish.Type.MEAT),
                new Dish("beef", false, 1000, Dish.Type.MEAT),
                new Dish("chicken", false, 1000, Dish.Type.MEAT)
        ));

        Stream<Dish> menuStream = menu.stream();

        StreamForker.Results results = new StreamForker<>(menuStream)
                .fork("shortMenu", s -> s.map(Dish::getName)
                        .collect(Collectors.joining(", ")))
                .fork("totalCalories", s -> s.mapToInt(Dish::getCalories).sum())
                .fork("mostCaloricDish", s -> s.collect(Collectors.reducing(
                        (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2))
                        .get())
                .fork("dishesByType", s -> s.collect(Collectors.groupingBy(Dish::getType)))
                .getResults();

        String shortMenu = results.get("shortMenu");
        int totalCalories = results.get("totalCalories");
        Dish mostCaloricDish = results.get("mostCaloricDish");
        Map<Dish.Type, List<Dish>> dishesByType = results.get("dishesByType");

        System.out.println("Short Menu: " + shortMenu);
        System.out.println("Total calories: " + totalCalories);
        System.out.println("Most caloric dish: " + mostCaloricDish);
        System.out.println("Dishes by type: " + dishesByType);
    }
}
