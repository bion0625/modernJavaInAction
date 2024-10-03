package com.modernJava.stream;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class Introduction {
    static class Dish {
        public Dish() {}
        public Dish(String name, boolean vegetarian, int calories, Type type) {
            this.name = name;
            this.vegetarian = vegetarian;
            this.calories = calories;
            this.type = type;
        }
        private String name;
        private boolean vegetarian;
        private int calories;
        private Type type;

        public String getName() {
            return this.name;
        }

        public boolean isVegetarian() {
            return this.vegetarian;
        }

        public int getCalories() {
            return this.calories;
        }

        public Type getType() {
            return this.type;
        }

        @Override
        public String toString() {
            return name;
        }

        public enum Type { MEAT,OTHER,FISH }
    }

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
        List<Dish> lowCaloricDishies = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() > 400) {
                lowCaloricDishies.add(dish);
            }
        }
        Collections.sort(lowCaloricDishies, new Comparator<Dish>() {
            @Override
            public int compare(Dish dish1, Dish dish2) {
                return Integer.compare(dish1.getCalories(), dish2.getCalories());
            }
        });
        List<String> lowCaloricDishesNames1 = new ArrayList<>();
        for (Dish dish : lowCaloricDishies) {
            lowCaloricDishesNames1.add(dish.getName());
        }

        System.out.println("lowCaloricDishesNames1: " + lowCaloricDishesNames1);

        List<String> lowCaloricDishesNames2 = menu.stream()
                .filter(d -> d.getCalories() > 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .toList();

        System.out.println("lowCaloricDishesNames2: " + lowCaloricDishesNames2);

        List<String> lowCaloricDishesNames3 = menu.parallelStream()
                .filter(d -> d.getCalories() > 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .toList();

        System.out.println("lowCaloricDishesNames3: " + lowCaloricDishesNames3);

        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println("dishesByType: " + dishesByType);
    }
}
