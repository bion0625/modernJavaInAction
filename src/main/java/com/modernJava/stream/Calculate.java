package com.modernJava.stream;

import java.util.ArrayList;
import java.util.List;

public class Calculate {
    public static void main(String[] args) {
        List<Introduction.Dish> menu = new ArrayList<>(List.of(
                new Introduction.Dish("prawns", false, 3203, Introduction.Dish.Type.FISH),
                new Introduction.Dish("salmon", false, 300, Introduction.Dish.Type.FISH),
                new Introduction.Dish("french", false, 140, Introduction.Dish.Type.OTHER),
                new Introduction.Dish("fries", false, 561, Introduction.Dish.Type.OTHER),
                new Introduction.Dish("rice", false, 70, Introduction.Dish.Type.OTHER),
                new Introduction.Dish("season", false, 42, Introduction.Dish.Type.OTHER),
                new Introduction.Dish("fruit", true, 1000, Introduction.Dish.Type.OTHER),
                new Introduction.Dish("pizza", false, 1000, Introduction.Dish.Type.OTHER),
                new Introduction.Dish("pork", false, 1000, Introduction.Dish.Type.MEAT),
                new Introduction.Dish("beef", false, 1000, Introduction.Dish.Type.MEAT),
                new Introduction.Dish("chicken", false, 1000, Introduction.Dish.Type.MEAT)
        ));

        List<String> names =
                menu.stream()
                .filter(dish -> {
                    System.out.println("filtering: " + dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping: " + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .toList();
        System.out.println(names);

        menu.stream().forEach(System.out::println);
    }
}
