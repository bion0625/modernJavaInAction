package com.modernJava.optionalClassInsteadOfNull.practicalExampleUsingOptionalClass;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class PracticalExampleUsingOptionalClass {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        Object value = map.get("key");
        System.out.println("value: " + value);
        Optional<Object> optValue = Optional.ofNullable(map.get("key"));

        String s = "5";
        System.out.println(s + " -> " + stringToInt(s).orElse(0));
        s = "A";
        System.out.println(s + " -> " + stringToInt(s).orElse(0));

        PracticalExampleUsingOptionalClass app = new PracticalExampleUsingOptionalClass();

        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-1");

        assertEquals(5, app.readDuration(props, "a"));
        assertEquals(0, app.readDuration(props, "b"));
        assertEquals(0, app.readDuration(props, "c"));

        System.out.println("a -> " + app.readDuration(props, "a"));
        System.out.println("b -> " + app.readDuration(props, "b"));
        System.out.println("c -> " + app.readDuration(props, "c"));

        System.out.println("a -> " + app.readDurationRenewal(props, "a"));
        System.out.println("b -> " + app.readDurationRenewal(props, "b"));
        System.out.println("c -> " + app.readDurationRenewal(props, "c"));
    }

    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        }catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public int readDuration(Properties props, String name) {
        String value = props.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) return i;
            } catch (NumberFormatException nfe) {}
        }
        return 0;
    }

    public int readDurationRenewal(Properties props, String name) {
//        String value = props.getProperty(name);
//        return stringToInt(value).filter(v -> v > 0).orElse(0);
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(PracticalExampleUsingOptionalClass::stringToInt)
                .filter(i -> i > 0)
                .orElse(0);
    }
}
