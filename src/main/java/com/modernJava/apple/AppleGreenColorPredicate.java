package com.modernJava.apple;

import static com.modernJava.apple.AppleColor.GREEN;

public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }
}
