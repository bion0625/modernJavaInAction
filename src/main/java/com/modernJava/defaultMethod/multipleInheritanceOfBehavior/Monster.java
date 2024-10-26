package com.modernJava.defaultMethod.multipleInheritanceOfBehavior;

public class Monster implements Rotatable, Moveable, Resizable {

    private int x;
    private int y;
    private int width;
    private int height;
    private int angleInDegrees;

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void setAbsoluteSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void setRotationAngle(int angleInDegrees) {
        this.angleInDegrees = angleInDegrees;
    }

    @Override
    public int getRotationAngle() {
        return this.angleInDegrees;
    }

    public Monster(int x,int y,int width,int height,int angleInDegrees) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.angleInDegrees = angleInDegrees;
    }
    public Monster() {}

    @Override
    public String toString() {
        return "Monster{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", angleInDegrees=" + angleInDegrees +
                '}';
    }
}
