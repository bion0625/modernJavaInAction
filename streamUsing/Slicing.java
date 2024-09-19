package streamUsing;

import java.util.Arrays;
import java.util.List;

public class Slicing {
    public static void main(String[] args) {
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));
        System.out.println("specialMenu: " + specialMenu);

        List<Dish> filteredMenu = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .toList();
        System.out.println("filteredMenu: " + filteredMenu);

        List<Dish> sliceMenu1 = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .toList();
        System.out.println("sliceMenu1: " + sliceMenu1);

        List<Dish> sliceMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .toList();
        System.out.println("sliceMenu2: " + sliceMenu2);

        List<Dish> dishes1 = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .toList();
        System.out.println("dishes1: " + dishes1);

        List<Dish> dishes2 = specialMenu.stream().filter(dish -> dish.getCalories() > 300).skip(2).toList();
        System.out.println("dishes2: " + dishes2);

        List<Dish> meatDishes = specialMenu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(2)
                .toList();
        System.out.println("meatDishes: " + meatDishes);
    }
}
