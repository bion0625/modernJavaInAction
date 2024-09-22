package streamUsing;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reducing {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 5, 3, 9);

        int sum1 = 0;
        for (Integer number : numbers) {
            sum1 += number;
        }
        System.out.println("sum1: " + sum1);

        int sum2 = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("sum2: " + sum2);

        int sum3 = numbers.stream().reduce(0, Integer::sum);
        System.out.println("sum3: " + sum3);

        Optional<Integer> sum4 = numbers.stream().reduce((a, b) -> a + b);
        System.out.println("sum4: " + sum4);

        Optional<Integer> max = numbers.stream().reduce(Math::max);
        System.out.println("max: " + max);

        List<Dish> menu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));
        int count1 = menu.stream()
                .mapToInt(dish -> 1)
                .reduce(0, (a, b) -> a + b);
        System.out.println("count1: " + count1);

        long count2 = menu.stream().count();
        System.out.println("count2: " + count2);

        int sum5 = numbers.parallelStream().reduce(0, Integer::sum);
        System.out.println("sum5: " + sum5);
    }
}
