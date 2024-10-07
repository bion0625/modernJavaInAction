package com.modernJava.collectionAPIRenewal;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionFactory {
    public static void main(String[] args) {
        ArrayList<String> friends1 = new ArrayList<>();
        friends1.add("Raphael");
        friends1.add("Olivia");
        friends1.add("Thibaut");
        System.out.println("friends1: " + friends1);

        List<String> friends2 = Arrays.asList("Raphael", "Olivia");
        friends2.set(0, "Richard");
//        friends2.add("Thibaut");
        System.out.println("friends2: " + friends2);

        Set<String> friends3 = new HashSet<>(Arrays.asList("Raphael", "Olivia", "Thibaut"));
        System.out.println("friends3: " + friends3);

        Set<String> friends4 = Stream.of("Raphael", "Olivia", "Thibaut").collect(Collectors.toSet());
        System.out.println("friends4: " + friends4);

        List<String> friends5 = List.of("Raphael", "Olivia", "Thibaut");
        System.out.println("friends5: " + friends5);

//        friends5.add("Chih-Chun");
//        System.out.println("friends5: " + friends5);

        Set<String> friends6 = Set.of("Raphael", "Olivia", "Thibaut");
        System.out.println("friends6: " + friends6);

//        Set<String> friends7 = Set.of("Raphael", "Olivia", "Olivia");
//        System.out.println("friends7: " + friends7);

        Map<String, Integer> ageOfFriends1
                = Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 26);
        System.out.println("ageOfFriends1: " + ageOfFriends1);

        Map<String, Integer> ageOfFriends2 = Map.ofEntries(
                Map.entry("Raphael", 30),
                Map.entry("Olivia", 25),
                Map.entry("Thibaut", 26));
        System.out.println("ageOfFriends2: " + ageOfFriends2);

//        List<String> actors = List.of("Keanu", "Jessica");
//        actors.set(0, "Brad");
//        System.out.println(actors);
    }
}
