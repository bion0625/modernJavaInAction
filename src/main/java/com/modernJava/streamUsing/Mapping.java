package com.modernJava.streamUsing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Mapping {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .toList();
        System.out.println("dishNames: " + dishNames);

        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .toList();
        System.out.println("wordLengths: " + wordLengths);

        List<Integer> dishNameLengths = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .toList();
        System.out.println("dishNameLengths: " + dishNameLengths);

        List<String[]> sample1 = words.stream()
                .map(word -> word.split(""))
                .distinct()
                .toList();
        System.out.println("sample1: " + sample1);

        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
        List<Stream<String>> sample2 = words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .toList();
        System.out.println("sample2: " + sample2);

        List<String> uniqueCharacters = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct().toList();
        System.out.println("uniqueCharacters: " + uniqueCharacters);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream().map(number -> number * number).toList();
        System.out.println("squares: " + squares);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs1 = numbers1.stream()
                .flatMap(number1 -> numbers2.stream()
                        .map(number2 -> new int[]{number1, number2}))
                .toList();
        for (int[] pair1 : pairs1) System.out.println("pair1: " + Arrays.toString(pair1));

        List<int[]> pairs2 = numbers1.stream()
                .flatMap(number1 ->
                        numbers2.stream()
                                .filter(number2 -> (number1 + number2) % 3 == 0)
                                .map(number2 -> new int[]{number1, number2}))
                .toList();
        for (int[] pair2 : pairs2) System.out.println("pair2: " + Arrays.toString(pair2));
    }
}
