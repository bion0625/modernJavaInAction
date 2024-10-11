package com.modernJava.apple;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilteringApplesTest {

    @Test
    void testFilter() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> even = FilteringApples.filter(numbers, i -> i % 2 == 0);
        List<Integer> smallerThanThree = FilteringApples.filter(numbers, i -> i < 3);
        assertEquals(Arrays.asList(2, 4), even);
        assertEquals(Arrays.asList(1, 2), smallerThanThree);
    }
}