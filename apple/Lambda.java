package apple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static apple.AppleColor.GREEN;
import static apple.AppleColor.RED;

public class Lambda {
    public static void main(String[] args) throws IOException {
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

        System.out.println(processFile1());

        System.out.println(processFile2(b -> b.readLine()));

        System.out.println(processFile2(b -> b.readLine() + b.readLine()));
        System.out.println(processFile2((BufferedReader br) -> br.readLine() + br.readLine()));

        Predicate<String> filter = (String s) -> !s.isEmpty();

        List<String> tempList = Arrays.asList("a", "b", "c");
        System.out.println("tempList: " + tempList);
        tempList = filter(tempList, (String s) -> !s.isEmpty());
        System.out.println("tempList: " + tempList);

        forEach(Arrays.asList(1,2,3,4), (Integer i) -> System.out.println(i));

        List<Integer> l = map(Arrays.asList("lambdas", "in", "action"), (String s) -> s.length());
        System.out.println("l: " + l);

        Supplier<Apple> apple = () -> new Apple();

    }

    public static void process(Runnable r) {
        r.run();
    }

    public static String processFile1() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }

    public static String processFile2(BufferdReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) results.add(t);
        }
        return results;
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }
}
