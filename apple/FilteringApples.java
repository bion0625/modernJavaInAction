package apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static apple.AppleColor.GREEN;
import static apple.AppleColor.RED;

public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(GREEN, 80),
                new Apple(GREEN, 155),
                new Apple(RED, 120));
        List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
        List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());

        System.out.println("heavyApples: " + heavyApples);
        System.out.println("greenApples: " + greenApples);

        List<Apple> newGreenApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return GREEN.equals(apple.getColor());
            }
        });

        System.out.println("newGreenApples: " + newGreenApples);

        List<Apple> resut = filterApples(inventory, a -> RED.equals(a.getColor()));
        System.out.println("result: " + resut);

        List<Apple> redApples = filter(inventory, (Apple apple) -> RED.equals(apple.getColor()));
        System.out.println("redApples: " + redApples);

        List<Apple> evenNumbers = filter(inventory, (Apple apple) -> apple.getWeight() % 2 == 0);
        System.out.println("evenNumbers: " + evenNumbers);
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
    
    public interface Predicate<T> {
        boolean test(T t);
    }
    
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}
