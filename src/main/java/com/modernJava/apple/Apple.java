package com.modernJava.apple;

public class Apple{
    private AppleColor appleColor;
    private int weight;

    public Apple() {}
    public Apple(AppleColor appleColor, int weight) {
        this.appleColor = appleColor;
        this.weight = weight;
    }
    public Apple(Integer weight) {
        this.weight = weight;
    }

    public AppleColor getColor() {return this.appleColor;}
    public void setColor(AppleColor appleColor) {this.appleColor = appleColor;}
    public Integer getWeight() {return this.weight;}
    public void setWeight(int weight) {this.weight = weight;}

    @Override
    public String toString() {
        return "Apple{" +
                "appleColor=" + appleColor +
                ", weight=" + weight +
                '}';
    }
}