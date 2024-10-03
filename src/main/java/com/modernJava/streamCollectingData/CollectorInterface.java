package com.modernJava.streamCollectingData;

import com.modernJava.streamUsing.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorInterface {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        List<Dish> dishes1 = menu.stream().collect(new ToListCollector<>());
        System.out.println("dishes1: " + dishes1);

        List<Dish> dishes2 = menu.stream().collect(Collectors.toList());
        System.out.println("dishes2: " + dishes2);

        ArrayList<Dish> dishes3 = menu.stream().collect(ArrayList::new, List::add, List::addAll);
        System.out.println("dishes3: " + dishes3);
    }
}
