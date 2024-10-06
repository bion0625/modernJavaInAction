package com.modernJava.spliteratorInterface;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SpliteratorInterface {
    public static void main(String[] args) {
        final String SENTENCE =
                "Nel mezzo del cammin di nostra vita " +
                "mi ritrovai per una selva oscura " +
                "ché la diritta via era smarrita ";
        System.out.println("Fount " + countWordsIteratively(SENTENCE) + " words");

        Stream<Character> stream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
        System.out.println("Found " + countWords(stream) + " words");
//        Stream<Character> streamParallel = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
//        System.out.println("Found " + countWords(streamParallel.parallel()) + " words");
        WordCounterSpliterator spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> streamParallel = StreamSupport.stream(spliterator, true);
        System.out.println("Found " + countWords(streamParallel) + " words");
    }

    static public int countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) lastSpace = true;
            else {
                if (lastSpace) counter++;
                lastSpace = false;
            }
        }
        return counter;
    }

    static private int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
                                                WordCounter::accumulate,
                                                WordCounter::combine);
        return wordCounter.getCounter();
    }
}
