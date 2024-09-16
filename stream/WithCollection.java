package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WithCollection {
    public static void main(String[] args) {
        streamClose();
    }

    static void streamClose() {
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
//        s.forEach(System.out::println); // error
    }
}
