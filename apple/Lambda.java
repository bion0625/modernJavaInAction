package apple;

import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static apple.AppleColor.GREEN;
import static apple.AppleColor.RED;

public class Lambda {
    public static void main(String[] args) {
        Comparator<Apple> byWeight = new Comparator<>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        };

        byWeight = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());

        PrivilegedAction<Integer> integerPrivilegedAction = () -> 42;

        Runnable runnable = () -> {
            System.out.println("runable run !");
        };

        runnable.run();

        PrivilegedAction<String> stringPrivilegedAction = () -> "Raoul";

        Runnable runnableCreateGreenApple = () -> new Apple(GREEN, 80);

        runnableCreateGreenApple.run();

        List<Apple> inventory = Arrays.asList(
                new Apple(GREEN, 80),
                new Apple(GREEN, 155),
                new Apple(RED, 120));
        List<Apple> greenApple = FilteringApples.filter(inventory, (Apple a) -> GREEN.equals(a.getColor()));

        System.out.println("greenApple: " + greenApple);

        Runnable r1 = () -> System.out.println("Hello world 1");

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world 2");
            }
        };

        process(r1);
        process(r2);
        process(() -> System.out.println("Hello world 3"));

        process(() -> System.out.println("This is awesome!!"));

    }

    public static void process(Runnable r) {
        r.run();
    }
}
