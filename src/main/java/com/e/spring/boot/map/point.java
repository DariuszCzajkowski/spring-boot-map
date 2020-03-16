package com.e.spring.boot.map;

public class point {


    private double x;
    private double y;
    private String text;


    public point(double x, double y, String text) {
        this.x = x;
        this.y = y;
        this.text = text;
    }

    public point() {
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "point{" +
                "x=" + x +
                ", y=" + y +
                ", text='" + text + '\'' +
                '}';
    }
}
