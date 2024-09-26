package streamUsing;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Making {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Modern", "Java", "In", "Action"); stream
                .map(String::toUpperCase).forEach(System.out::println);

        Stream<String> emptyStream = Stream.empty();

        String homeValue = System.getProperty("home"); // java.version
        Stream<String> homeValueStream1 = homeValue == null ? Stream.empty() : Stream.of(homeValue);
        homeValueStream1.forEach(System.out::println);

        Stream<String> homeValueStream2 = Stream.ofNullable(System.getProperty("home")); // java.version
        homeValueStream2.forEach(System.out::println);

        Stream<String> values =
                Stream.of("config", "home", "user") // "os.name", "os.version", "java.version"
                        .flatMap(key -> Stream.ofNullable(System.getProperty(key)));
        values.forEach(System.out::println);

        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println("sum: " + sum);

        long uniqueWords = 0;
        try(Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch(IOException e) {
        }
        System.out.println("uniqueWords: " + uniqueWords);

        Stream.iterate(0, n -> n+2)
                .limit(10)
                .forEach(System.out::println);

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0]+t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));

        Stream.iterate(0, n -> n < 100, n -> n+ 4)
                .forEach(System.out::println);

        IntStream.iterate(0, n -> n+4)
                .takeWhile(n -> n < 100)
                .forEach(System.out::println);

        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        IntStream ones = IntStream.generate(() -> 1);
        ones.limit(10).forEach(System.out::println);

        IntStream twos = IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return 2;
            }
        });
        twos.limit(10).forEach(System.out::println);

        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::println);
    }
}
