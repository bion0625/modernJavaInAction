package streamCollectingData;

import streamUsing.Dish;

import java.util.*;
import java.util.stream.Collectors;

public class Grouping {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        Map<Dish.Type, List<Dish>> dishesByType
                = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println("dishesByType: " + dishesByType);

        enum CaloricLevel { DIET, NORMAL, FAT };

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                Collectors.groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }));
        System.out.println("dishesByCaloricLevel: " + dishesByCaloricLevel);

        Map<Dish.Type, List<Dish>> caloricDishByType1 = menu.stream()
                .filter(dish -> dish.getCalories() > 500)
                .collect(Collectors.groupingBy(Dish::getType));
        System.out.println("caloricDishByType1: " + caloricDishByType1);

        Map<Dish.Type, List<Dish>> caloricDishByType2
                = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.filtering(dish -> dish.getCalories() > 500, Collectors.toList())));
        System.out.println("caloricDishByType2: " + caloricDishByType2);

        Map<Dish.Type, List<String>> dishNamesByType1 =
                menu.stream()
                        .collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(Dish::getName, Collectors.toList())));
        System.out.println("dishNamesByType1: " + dishNamesByType1);

        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork",Arrays.asList("greasy","salty"));
        dishTags.put("beef",Arrays.asList("salty","roasted"));
        dishTags.put("chicken",Arrays.asList("fried","crisp"));
        dishTags.put("french fries",Arrays.asList("greasy","fried"));
        dishTags.put("rice",Arrays.asList("light","natural"));
        dishTags.put("season fruit",Arrays.asList("fresh","natural"));
        dishTags.put("pizza",Arrays.asList("tasty","salty"));
        dishTags.put("prawns",Arrays.asList("tasty","roasted"));
        dishTags.put("salmon",Arrays.asList("delicious","fresh"));

        Map<Dish.Type, Set<String>> dishNamesByType2 = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.flatMapping(dish -> dishTags.get(dish.getName()).stream(), Collectors.toSet())));
        System.out.println("dishNamesByType2: " + dishNamesByType2);

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        Collectors.groupingBy(Dish::getType,
                                Collectors.groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                })));
        System.out.println("dishesByTypeCaloricLevel: " + dishesByTypeCaloricLevel);

        Map<Dish.Type, Optional<Dish>> mostCaloricByType1 =
                menu.stream().collect(
                        Collectors.groupingBy(Dish::getType,
                                Collectors.maxBy(Comparator.comparing(Dish::getCalories))));
        System.out.println("mostCaloricByType1: " + mostCaloricByType1);

        Map<Dish.Type, Dish> mostCaloricByType2 =
                menu.stream().collect(
                        Collectors.groupingBy(Dish::getType,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparing(Dish::getCalories)),
                                        Optional::get)));
        System.out.println("mostCaloricByType2: " + mostCaloricByType2);

        Map<Dish.Type, Integer> totalCaloriesByType =
                menu.stream().collect(Collectors.groupingBy(Dish::getType,
                        Collectors.summingInt(Dish::getCalories)));
        System.out.println("totalCaloriesByType: " + totalCaloriesByType);

        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType1 = menu.stream().collect(
                Collectors.groupingBy(Dish::getType,
                        Collectors.mapping(dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;},
                                Collectors.toSet())));
        System.out.println("caloricLevelsByType1: " + caloricLevelsByType1);

        Map<Dish.Type, HashSet<CaloricLevel>> caloricLevelsByType2 = menu.stream().collect(
                Collectors.groupingBy(Dish::getType,
                        Collectors.mapping(dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;},
                                Collectors.toCollection(HashSet::new))));
        System.out.println("caloricLevelsByType2: " + caloricLevelsByType2);
    }
}
