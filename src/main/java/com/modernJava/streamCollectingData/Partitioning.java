package com.modernJava.streamCollectingData;


import com.modernJava.streamUsing.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Partitioning {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        Map<Boolean, List<Dish>> partitionedMenu =
                menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println("partitionedMenu: " + partitionedMenu);

        List<Dish> vegetarianDishes1 = partitionedMenu.get(true);
        System.out.println("vegetarianDishes1: " + vegetarianDishes1);

        List<Dish> vegetarianDishes2 =
                menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
        System.out.println("vegetarianDishes2: " + vegetarianDishes2);

        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = menu.stream()
                .collect(
                        Collectors.partitioningBy(Dish::isVegetarian,
                                Collectors.groupingBy(Dish::getType)));
        System.out.println("vegetarianDishesByType: " + vegetarianDishesByType);

        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian =
                menu.stream().collect(
                        Collectors.partitioningBy(Dish::isVegetarian,
                                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Dish::getCalories)),
                                        Optional::get)));
        System.out.println("mostCaloricPartitionedByVegetarian: " + mostCaloricPartitionedByVegetarian);

        Map<Boolean, Map<Boolean, List<Dish>>> q1 =
                menu.stream().collect(
                        Collectors.partitioningBy(Dish::isVegetarian,
                                Collectors.partitioningBy(d -> d.getCalories() > 500)));
        System.out.println("q1: " + q1);

//        R q2 = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.partitioningBy(Dish::getType)));

        Map<Boolean, Long> q3 =
                menu.stream().collect(
                        Collectors.partitioningBy(Dish::isVegetarian,
                                Collectors.counting()));
        System.out.println("q3: " + q3);

        Map<Boolean, List<Integer>> booleanListMap = partitionPrimes(10);
        System.out.println("booleanListMap: " + booleanListMap);
    }

    static Map<Boolean, List<Integer>> partitionPrimes (int n) {
        return IntStream.range(2, n).boxed()
                .collect(Collectors.partitioningBy(candidate -> isPrime(candidate)));
    }

    static public boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.range(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }
}
