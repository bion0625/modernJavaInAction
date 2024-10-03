package com.modernJava.streamCollectingData;

import com.modernJava.streamUsing.Dish;

import java.util.*;
import java.util.stream.Collectors;

public class ReducingAndSummary {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        Long count1 = menu.stream().collect(Collectors.counting());
        System.out.println("count1: " + count1);

        long count2 = menu.stream().count();
        System.out.println("count2: " + count2);

        Comparator<Dish> dishCaloriesComparator =
                Comparator.comparing(Dish::getCalories);

        Optional<Dish> mostCalorieDish1 =
                menu.stream()
                        .collect(Collectors.maxBy(dishCaloriesComparator));
        System.out.println("mostCalorieDish1: " + mostCalorieDish1);

        Integer totalCalories1 = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println("totalCalories1: " + totalCalories1);

        Double avgCalories = menu.stream().collect(Collectors.averagingDouble(Dish::getCalories));
        System.out.println("avgCalories: " + avgCalories);

        IntSummaryStatistics menuStatistics
                = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println("menuStatistics: " + menuStatistics);

        String shortMenu1 = menu.stream().map(Dish::getName).collect(Collectors.joining());
        System.out.println("shortMenu1: " + shortMenu1);

        String shortMenu2 = menu.stream().map(Dish::toString).collect(Collectors.joining());
        System.out.println("shortMenu2: " + shortMenu2);

        String shortMenu3 = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println("shortMenu3: " + shortMenu3);

        Integer totalCalories2 = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println("totalCalories2: " + totalCalories2);

        Optional<Dish> mostCalorieDish2 =
                menu.stream().collect(Collectors.reducing(
                        (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        System.out.println("mostCalorieDish2: " + mostCalorieDish2);

//        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
//        List<Integer> numbers = stream.reduce(
//                new ArrayList<>(),
//                (List<Integer> l, Integer e) -> {
//                    l.add(e);
//                    return l;
//                },
//                (List<Integer> l1, List<Integer> l2) -> {
//                    l1.addAll(l2);
//                    return l1;
//                });
//        System.out.println("numbers: " + numbers);

        Integer totalCalories3 = menu.stream().collect(Collectors.reducing(0,
                                        Dish::getCalories,
                                        Integer::sum));
        System.out.println("totalCalories3: " + totalCalories3);

        Integer totalCalories4 = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
        System.out.println("totalCalories4: " + totalCalories4);

        int totalCalories5 = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("totalCalories5: " + totalCalories5);

        String shortMenu4 = menu.stream().map(Dish::getName).collect(Collectors.joining());
        System.out.println("shortMenu4: " + shortMenu4);

        String shortMenu5 = menu.stream().collect(Collectors.reducing("", Dish::getName, (s1, s2) -> s1 + s2));
        System.out.println("shortMenu5: " + shortMenu5);
    }
}
