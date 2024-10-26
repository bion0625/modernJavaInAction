package com.modernJava.defaultMethod.multipleInheritanceOfBehavior;

public class Sun implements Rotatable, Moveable{
    private int x;
    private int y;
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
    public void setRotationAngle(int angleInDegrees) {
        this.angleInDegrees = angleInDegrees;
    }

    @Override
    public int getRotationAngle() {
        return this.angleInDegrees;
    }
}
