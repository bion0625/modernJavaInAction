package streamUsing;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SearchAndMatching {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        if (menu.stream().anyMatch(Dish::isVegetarian))
            System.out.println("The menu (somewhat) vegetarian friendly!!");

        boolean isHealthy = menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);
        if (isHealthy)
            System.out.println("The menu (somewhat) is healthy!!");

        Optional<Dish> dish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
        System.out.println("dish: " + dish);

        menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(d -> System.out.println(d.getName()));
//        menu.stream().filter(Dish::isVegetarian).findAny().ifPresentOrElse(d -> System.out.println(d.getName()), () -> System.out.println("is Empty"));

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst();// 9
    }
}
