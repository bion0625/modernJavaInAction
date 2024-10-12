package com.modernJava.aSmallDSLForTheLatestJavaAPI.collectorsAsDslForCollectingData;

public class Car {
    private String brand;
    private String color;

    public String getBrand() {return this. brand;}
    public String getColor() {return this. color;}

    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
