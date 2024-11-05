package com.modernJava.firstReactiveApplication;

import java.util.Random;

public class TempInfo {
    public static final Random random = new Random();

    private final String town;
    private final int temp;

    public TempInfo(String town, int temp) {
        this.town = town;
        this.temp = temp;
    }

    public static TempInfo fetch(String town) {
        if (random.nextInt(10) == 0) throw new RuntimeException();
        return new TempInfo(town, random.nextInt(100));
    }

    @Override
    public String toString() {
        return this.town + " : " + this.temp;
    }

    public int getTemp() {
        return this.temp;
    }

    public String getTown() {
        return this.town;
    }
}
