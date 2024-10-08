package com.modernJava.collectionAPIRenewal;

import java.security.NoSuchAlgorithmException;
import java.util.*;

public class MapProcessing {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Map<String, Integer> ageOfFriends
                = Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 26);

        for (Map.Entry<String, Integer> entry : ageOfFriends.entrySet()) {
            String friend = entry.getKey();
            Integer age = entry.getValue();
            System.out.println(friend + " is " + age + " years old");
        }

        ageOfFriends.forEach((friend, age) -> System.out.println(friend + " is " + age + " years old"));

        Map<String, String> favouriteMovies1
                = Map.ofEntries(Map.entry("Raphael", "Star Wars"),
                Map.entry("Cristina", "Matrix"),
                Map.entry("Olivia", "James Bond"));

        System.out.println("favouriteMovies1: " + favouriteMovies1);

        favouriteMovies1
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);

        Map<String, String> favouriteMovies2
                = Map.ofEntries(Map.entry("Raphael", "Star Wars"),
                Map.entry("Olivia", "James Bond"));

        System.out.println(favouriteMovies2.getOrDefault("Olivia", "Matrix"));
        System.out.println(favouriteMovies2.getOrDefault("Thibaut", "Matrix"));

        Map<String, List<String>> friendToMovies1 = new HashMap<>();
        String friend = "Raphael";
        List<String> movies1 = friendToMovies1.get(friend);
        if (movies1 == null) {
            movies1 = new ArrayList<>();
            friendToMovies1.put(friend, movies1);
        }
        movies1.add("Star wars");

        System.out.println("friendToMovies1: " + friendToMovies1);

        Map<String, List<String>> friendToMovies2 = new HashMap<>();

        System.out.println("friendToMovies2: " + friendToMovies2);
        friendToMovies2.computeIfAbsent(friend, name -> new ArrayList<>()).add("Star wars");
        System.out.println("friendToMovies2: " + friendToMovies2);

        Map<String, String> favouriteMovies3 = new HashMap<>();
        favouriteMovies3.put("Raphael", "Jack Reacher 2");
        favouriteMovies3.put("Olivia", "James Bond");

        System.out.println("favouriteMovies3: " + favouriteMovies3);
        removeMovie(favouriteMovies3);
        System.out.println("favouriteMovies3: " + favouriteMovies3);

        Map<String, String> favouriteMovies4 = new HashMap<>();
        favouriteMovies4.put("Raphael", "Jack Reacher 2");
        favouriteMovies4.put("Olivia", "James Bond");

        System.out.println("favouriteMovies4: " + favouriteMovies4);
        favouriteMovies4.remove("Raphael", "Jack Reacher 2");
        System.out.println("favouriteMovies4: " + favouriteMovies4);

        Map<String, String> favouriteMovies5 = new HashMap<>();
        favouriteMovies5.put("Raphael", "Star Wars");
        favouriteMovies5.put("Olivia", "James Bond");

        System.out.println("favouriteMovies5: " + favouriteMovies5);
        favouriteMovies5.replaceAll((key, value) -> value.toUpperCase());
        System.out.println("favouriteMovies5: " + favouriteMovies5);

        Map<String, String> family1 = Map.ofEntries(
                Map.entry("Teo", "Star wars"), Map.entry("Cristina", "James Bond"));
        Map<String, String> friends1 = Map.ofEntries(
                Map.entry("Raphael", "Star Wars"));
        Map<String, String> everyone1 = new HashMap<>(family1);
        everyone1.putAll(friends1);
        System.out.println("everyone1: " + everyone1);

        Map<String, String> family2 = Map.ofEntries(
                Map.entry("Teo", "Star wars"), Map.entry("Cristina", "James Bond"));
        Map<String, String> friends2 = Map.ofEntries(
                Map.entry("Raphael", "Star Wars"), Map.entry("Cristina", "Matrix"));
        Map<String, String> everyone2 = new HashMap<>(family2);
        friends2.forEach((k, v) -> everyone2.merge(k, v, (movie1, movie2) -> movie1 + " & " + movie2));
        System.out.println("everyone2: " + everyone2);

        Map<String, Long> moviesToCount1 = new HashMap<>();
        String movieName = "JamesBond";
        Long count = moviesToCount1.get(movieName);
        if (count == null) {
            moviesToCount1.put(movieName, 1L);
        } else moviesToCount1.put(movieName, count+1);
        System.out.println("moviesToCount1: " + moviesToCount1);

        Map<String, Long> moviesToCount2 = new HashMap<>();
        moviesToCount2.merge(movieName, 1L, (key, cnt) -> cnt+1);
        System.out.println("moviesToCount2: " + moviesToCount2);

        Map<String, Integer> movies2 = new HashMap<>();
        movies2.put("JamesBond", 20);
        movies2.put("Matrix", 15);
        movies2.put("Harry Potter", 5);
        System.out.println("movies2: " + movies2);

        Iterator<Map.Entry<String, Integer>> iterator = movies2.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() < 10) iterator.remove();
        }
        System.out.println("movies2: " + movies2);

        Map<String, Integer> movies3 = new HashMap<>();
        movies3.put("JamesBond", 20);
        movies3.put("Matrix", 15);
        movies3.put("Harry Potter", 5);
        System.out.println("movies3: " + movies3);
        movies3.entrySet().removeIf(entry -> entry.getValue() < 10);
        System.out.println("movies3: " + movies3);

    }

    public static boolean removeMovie(Map<String, String> favouriteMovies) {
        String key = "Raphael";
        String value = "Jack Reacher 2";
        if (favouriteMovies.containsKey(key) && Objects.equals(favouriteMovies.get(key), value)) {
            favouriteMovies.remove(key);
            return true;
        }
        else return false;
    }
}
